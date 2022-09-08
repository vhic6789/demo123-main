<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Footer -->
<footer class="page-footer font-small">
	<div class="footer-copyright text-center py-3">
		© 2015 Support: <a href="mailto:avukim1397@gmail.com"> avukim1397@gmail.com</a>
	</div>
</footer>
<!-- Footer -->

<script>
	window.setTimeout(function() {
		$(".alert").remove();
	}, 2000);

	$(document).ready(
			function() {
				$("#myInput").on(
						"keyup",
						function() {
							var value = $(this).val().toLowerCase();
							$("#myTable tr").filter(
									function() {
										$(this).toggle(
												$(this).text().toLowerCase()
														.indexOf(value) > -1)
									});
						});
			});

	var sc = document.getElementById("msgs");
	if(sc != null) sc.scrollTo(0, sc.scrollHeight);
	<c:if test="${pageContext.request.remoteUser != null}">
	    function autoGetNoti() {
	        $(document).ready(function() {
	          $(function() {
	              $.get("/api/getNotifi?name=${pageContext.request.remoteUser }",
	               function(data, status) {
	                  $("#noti").html(data);
	              });
	          });
	        });
	    }
	    autoGetNoti();
	    setInterval(autoGetNoti , 4000);
    </c:if>
    
    <c:if test="${mytrade.getStatus() == 1 }">
	    function autoGetStatus() {
	    	var form = document.getElementById("formcmt");
	        $(document).ready(function() {
		        $(function() {
		              $.get("/api/getStatus?id=${mytrade.getId() }",
		               function(data, status) {
		                  if(data == 0) form.style = "";
		                  else form.style = "display: none;";
		              });
		          });
		        });
	    }
		autoGetStatus();
		setInterval(autoGetStatus , 4000);
    </c:if>
</script>
</body>

</html>