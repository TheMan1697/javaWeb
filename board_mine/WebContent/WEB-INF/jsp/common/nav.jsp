<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <header>
            <div class="header-inner">
                <input type="checkbox" id="menuicon">
                <label for="menuicon">
                <img src="https://icons-for-free.com/iconfiles/png/512/grid-1321215619689584902.png" class="checkicon" width="130px">
              </label>
              <div class="sidebar">
                  <ul class="sidebar-ul">
                      <li class="sidebar-li">
                          <a href="${cp}/index" class="sidebar-a">Main</a>
                      </li>
                      <li class="sidebar-li">
                          <a href="${cp}/board/list?category=2" class="sidebar-a"><span>Notice</span></a>
                        </li>
                        <li class="sidebar-li">
                            <a href="${cp}/board/list" class="sidebar-a"><span>Board</span></a>
                        </li>
                         <c:if test="${not empty member}">
                      <li class="sidebar-li">
                          <a href="${cp}/member/logout" class="sidebar-a">Logout</a>
                      </li>
                      <li class="sidebar-li">
                          <a href="${cp}/member/myPage" class="sidebar-a">My account</a>
                      </li>
                        </c:if>
                       <c:if test="${empty member}">
                      <li class="sidebar-li">
                          <a href="${cp}/member/login" class="sidebar-a">Login</a>
                      </li>
                      <li class="sidebar-li">
                          <a href="${cp}/member/contract" class="sidebar-a">Register</a>
                      </li>
                      </c:if>
                    </ul>
              </div>
             <!--   <div class="header-inner-text" id="loading">
                <h1 class="header-inner-text1">Think &nbsp; & &nbsp; Fill</h1>
                <h1 class="header-inner-text2">Beyond &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  Space</h1>
              </div> -->
        </div>
    </header>