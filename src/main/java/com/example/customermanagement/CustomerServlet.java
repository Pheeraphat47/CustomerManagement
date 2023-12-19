package com.example.customermanagement;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // รับข้อมูลจากผู้ใช้
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String city = request.getParameter("city");

        // บันทึกข้อมูลลงในฐานข้อมูล
        Customer customer = new Customer();
        customer.setCustomerNumber(id);
        customer.setCustomerFirstName(firstname);
        customer.setCustomerLastName(lastname);
        customer.setAddressLine1(address);
        customer.setPhone(phone);
        customer.setCity(city);

        // สร้าง EntityManager ตามการ config persistence unit ของคุณ
        EntityManager entityManager = Persistence.createEntityManagerFactory("classic-models").createEntityManager();

        // สร้าง CustomerRepository พร้อมส่ง EntityManager เข้าไป
        CustomerRepository repository = new CustomerRepository(entityManager);

        repository.save(customer);

        // ปิด EntityManager
        entityManager.close();

        // แสดงข้อมูลลูกค้า
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>บันทึกข้อมูลลูกค้า</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>บันทึกข้อมูลลูกค้าสำเร็จ</h1>");
        out.println("<p>id: " + id + "</p>");
        out.println("<p>ชื่อ: " + firstname + "</p>");
        out.println("<p>นามสกุล: " + lastname + "</p>");
        out.println("<p>ที่อยู่: " + address + "</p>");
        out.println("<p>เบอร์โทรศัพท์: " + phone + "</p>");
        out.println("<p>เมือง: " + city + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
