<div class="container-fluid">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

  <!-- Page Heading -->
  <h1 class="h3 mb-2 text-gray-800">Tables</h1>
  <p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below.
    For more information about DataTables, please visit the <a target="_blank"
                                                               href="https://datatables.net">official DataTables documentation</a>.</p>

  <!-- DataTales Example -->
  <div class="card shadow mb-4">
    <div class="card-header py-3">
      <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
    </div>
    <div class="card-body">
      <div class="table-responsive">
        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
          <thead>
          <tr>
            <th>img</th>
            <th>id</th>
            <th>name</th>
            <th>price</th>
            <th>regdate</th>
          </tr>
          </thead>
          <tfoot>
          <tr>
            <th>img</th>
            <th>id</th>
            <th>name</th>
            <th>price</th>
            <th>regdate</th>
          </tr>
          </tfoot>
          <tbody>
          <c:forEach var="obj" items="${itemlist}">
            <tr>
              <td><img src ="/img/${obj.imgname}" style = "width : 50px; height : 50px"></td>
              <td>${obj.id}</td>
              <td>${obj.name}</td>
              <td><fmt:formatNumber value="${obj.price}" type="currency" /></td>
              <td><fmt:formatDate value="${obj.regdate}" pattern="yyyy-MM-dd" /></td>
            </tr>
          </c:forEach>
          </tbody>

        </table>
      </div>
    </div>
  </div>

</div>
<!-- /.container-fluid -->
