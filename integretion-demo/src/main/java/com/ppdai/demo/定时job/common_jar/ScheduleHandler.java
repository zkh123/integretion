package com.ppdai.demo.定时job.common_jar;

import com.ppdai.demo.定时job.common_jar.entity.JobMsgEntity;
import com.ppdai.demo.定时job.common_jar.jobManager.JobManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by huanglijun on 2017/12/26.
 */
public class ScheduleHandler extends HttpServlet {
    public ScheduleHandler() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.render(response, this.execute(request, response));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.render(response, this.execute(request, response));
    }

    private void render(HttpServletResponse response, JobMsgEntity jme) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(jme.toJson());
        out.close();
    }

    private JobMsgEntity execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        JobMsgEntity jme = this.GetJobMsg(request);
        if(jme == null) {
            throw new ServletException("请求参数为空！不允许！");
        } else if(Util.isEmptyValue(jme.getAction())) {
            throw new ServletException("未指定操作指令！");
        } else if(Util.isEmptyValue(jme.getJobClassFullName())) {
            throw new ServletException("未指定要操作的JOB，请检查配置是否正确，并指定JOB类的全称！");
        } else {
            String cmd = jme.getAction().toUpperCase();
            jme.setHostIp(this.getIp(request));
            if("RUN".equals(cmd)) {
                JobManager.getInstance().runJob(jme, false);
            } else {
                if(!"RUNPARALLE".equals(cmd)) {
                    throw new ServletException("无法解析指令：" + jme.getAction());
                }

                JobManager.getInstance().runJob(jme, true);
                jme.setNeedParallel(Boolean.valueOf(true));
            }

            return jme;
        }
    }

    private String getIp(HttpServletRequest request) {
        return Util.getRemoteHost(request);
    }

    private JobMsgEntity GetJobMsg(HttpServletRequest request) {
        JobMsgEntity jme = new JobMsgEntity();
        jme.setAction(request.getParameter("action"));
        jme.setHostIp(request.getParameter("hostip"));
        jme.setJobClassFullName(request.getParameter("jobclassfullname"));
        jme.setJobInfo(request.getParameter("jobinfo"));
        jme.setParam(request.getParameter("param"));
        return jme;
    }
}
