package no.hib.megagruppe.webpoll.servlets;

import no.hib.megagruppe.webpoll.util.VersionInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet to expose the build number of the deployed application
 */
@WebServlet("/version")
public class VersionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json");

        VersionInfo versionInfo = new VersionInfo(getServletContext());
        resp.getWriter().print(buildJson(versionInfo));
    }

    private String buildJson(VersionInfo versionInfo) {
        return "{ \"build\": \"" + versionInfo.getBuildNumber()
                + "\", \"revision\": \"" + versionInfo.getRevision() + "\" }";
    }
}
