<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>은행별 환율</title>
        <link href="${pageContext.request.contextPath}/resources/dist/css/styles.css" rel="stylesheet" />
        <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
        
        <%@ include file="include/nav.jsp" %>
        
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
            
            	<%@ include file="include/aside.jsp" %>
                
            </div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid">
                        <table class='table borderless'>
                            <td align=center valign=center>
                            	<div>
                            		<button class="btn btnEvent" type="button" onclick = "location.href = '/sinlist.do' ">
                            			<img class="logo_img" src='${pageContext.request.contextPath}/resources/img/sinhan.jpg'"/>
                            		</button>
                            	</div>
                            </td>
                            <td align=center valign=center><div><button type="button" class="btn btnEvent" onclick = "location.href = '/kuklist.do' "><img class="logo_img" src='${pageContext.request.contextPath}/resources/img/kukmin.jpg'"/></button></div></td>
                            <td align=center valign=center><div><button type="button" class="btn btnEvent" onclick = "location.href = '/nhlist.do' "><img class="logo_img" src='${pageContext.request.contextPath}/resources/img/nh.png'"/></button></div></td>
                            <td align=center valign=center><div><button type="button" class="btn btnEvent" onclick = "location.href = '/hanalist.do' "><img class="logo_img" src='${pageContext.request.contextPath}/resources/img/hana.png'"/></button></div></td>
                            <td align=center valign=center><div><button type="button" class="btn btnEvent" onclick = "location.href = '/urilist.do' "><img class="logo_img" src='${pageContext.request.contextPath}/resources/img/uri.jpg'"/></button></div></td>
                        </table>
                        <c:choose>
                        	<c:when test="${name eq '신한'}"><img class="logo_img_selected" src='${pageContext.request.contextPath}/resources/img/sinhan.jpg'/></c:when>
                        	<c:when test="${name eq '국민'}"><img class="logo_img_selected" src='${pageContext.request.contextPath}/resources/img/kukmin.jpg'/></c:when>
                        	<c:when test="${name eq '농협'}"><img class="logo_img_selected" src='${pageContext.request.contextPath}/resources/img/nh.png'/></c:when>
                        	<c:when test="${name eq '하나'}"><img class="logo_img_selected" src='${pageContext.request.contextPath}/resources/img/hana.png'/></c:when>
                        	<c:when test="${name eq '우리'}"><img class="logo_img_selected" src='${pageContext.request.contextPath}/resources/img/uri.jpg'/></c:when>
                        	<c:otherwise><img class="logo_img_selected" src='${pageContext.request.contextPath}/resources/img/sinhan.jpg'/></c:otherwise>
                        </c:choose>
                        <div class="card mb-4">
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-striped" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>국가명</th>
                                                <th>살때</th>
                                                <th>팔때</th>
                                                <th>매매기준률</th>
                                                <th>수수료(%)</th>
                                            </tr>
                                        </thead>
                                        <tbody id="table1">
                                        	<c:forEach items="${list}" var="item">
												<tr>
													<th>${item.counNa}</th>
													<th>${item.buy}</th>
													<th>${item.sell}</th>
													<th>${item.tbRate}</th>
													<th>${item.fees}</th>
												</tr>
											</c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; dhstudio 2020</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="${pageContext.request.contextPath}/resources/dist/js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="${pageContext.request.contextPath}/resources/dist/assets/demo/chart-area-demo.js"></script>
        <script src="${pageContext.request.contextPath}/resources/dist/assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
        <script src="${pageContext.request.contextPath}/resources/dist/assets/demo/datatables-demo.js"></script>
    </body>
</html>
