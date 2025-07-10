package com.example.calendar;

import com.example.calendar.data.HistoryStack;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = {"/calendar"})
public class CalendarServlet extends HttpServlet {
    private final HistoryStack<String> navigationHistory = new HistoryStack<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int year = Integer.parseInt(request.getParameter("year"));
        int month = Integer.parseInt(request.getParameter("month"));
        navigationHistory.push(year + "-" + month);

        List<List<String>> calendar = CalendarGenerator.generateCalendar(year, month);

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print("[");
        for (int i = 0; i < calendar.size(); i++) {
            out.print("[");
            List<String> week = calendar.get(i);
            for (int j = 0; j < week.size(); j++) {
                out.print("\"" + week.get(j) + "\"");
                if (j < week.size() - 1) out.print(",");
            }
            out.print("]");
            if (i < calendar.size() - 1) out.print(",");
        }
        out.print("]");
        out.flush();
    }
}