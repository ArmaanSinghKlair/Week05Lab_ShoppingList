/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.*;
/**
 *
 * @author 839645
 */
public class ShoppingListServlet extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sess = request.getSession();
        String url;
        String action =(String) request.getParameter("action"); 
        if(action!=null){
            sess.invalidate();
            url="/WEB-INF/register.jsp";
            request.setAttribute("message", "You have successfully logged out!");
        }else{
            if(sess.getAttribute("username") == null)
                url="/WEB-INF/register.jsp";
            else{
                url="/WEB-INF/shoppingList.jsp";
            }
        }
        this.getServletContext().getRequestDispatcher(url).forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sess = request.getSession();
        String action = request.getParameter("action");
        ArrayList<String> listItems = (ArrayList<String>) sess.getAttribute("shoppingListItems");
        String url="";
        
        switch(action){
            case "register":
                String username = (String)request.getParameter("username");
                if(validate(username)){
                    sess.setAttribute("username", username); 
                    url="/WEB-INF/shoppingList.jsp";
                }
                else {
                    url="/WEB-INF/register.jsp";
                    request.setAttribute("message","All fields required!");
                    request.setAttribute("username", username);
                }
                break;
            case "add":
                String itemToAdd = (String) request.getParameter("itemToAdd");
                url="/WEB-INF/shoppingList.jsp";

                if(validate(itemToAdd)){
                    if(listItems == null)
                        listItems = new ArrayList();
                    listItems.add(itemToAdd);
                } else{
                    request.setAttribute("message","All fields required!");
                }
                break;
            case "delete":
                String itemToDelete = (String) request.getParameter("itemToDelete");
                url="/WEB-INF/shoppingList.jsp";

                if(validate(itemToDelete)){
                    listItems.remove(itemToDelete);
                } else{
                    request.setAttribute("message","Select an element to Delete!");
                }
                
        }
        
        sess.setAttribute("shoppingListItems", listItems);
        
        this.getServletContext().getRequestDispatcher(url).forward(request, response);
        
    }
    
    private boolean validate(String s){
        if(s==null || s.trim().equals(""))
            return false;
        else
            return true;
            
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
