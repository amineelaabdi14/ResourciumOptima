<%@ page import="entities.Equipment" %>
<%@ page import="java.util.List" %>
<%@ page import="entities.Employee" %>
<%@ page import="entities.EquipmentToEmployee" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="./components/head.jsp" %>
<html>
<body>

<div class="details">
    <div class="recentOrders">
        <div class="cardHeader d-flex flex-row justify-content-end">
            <a href="#modal-reservation-add" data-bs-toggle="modal" class="btns">Add Reservation</a>
        </div>

        <table class="">
            <thead>
            <tr>
                <td>User</td>
                <td>Equipment</td>
                <td>reservationDate</td>
                <td>returnDate</td>
                <td>Operations</td>
            </tr>
            </thead>
            <tbody>
                        <%
                            List<EquipmentToEmployee> equipmentsToEmployees = (List<EquipmentToEmployee>) request.getAttribute("equipmentsToEmployees");
                            if (equipmentsToEmployees != null) {
                                for (EquipmentToEmployee reservation : equipmentsToEmployees) {
                        %>
            <tr>
                <td><%= reservation.EmployeeId.getFullName() %>
                </td>
                <td><%= reservation.EquipmentId.getName() %>
                </td>
                <td><%= reservation.getStartDate() %>
                </td>
                <td><%= reservation.getEndDate() %>
                </td>
                <td>
                    <a id="edit-button" href="#modal-reservation-edit" data-bs-toggle="modal">
                        <ion-icon name="create-outline"></ion-icon>
                    </a>

                    <form class="d-inline" method="POST"
                          action="${pageContext.request.contextPath}/reservation/delete">
                        <input type="hidden" name="reservationId" value="<%=reservation.id%>">
                        <button class="unstyled" type="submit" style="border: none">
                            <i><svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 448 512"><!--! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. --><path d="M135.2 17.7L128 32H32C14.3 32 0 46.3 0 64S14.3 96 32 96H416c17.7 0 32-14.3 32-32s-14.3-32-32-32H320l-7.2-14.3C307.4 6.8 296.3 0 284.2 0H163.8c-12.1 0-23.2 6.8-28.6 17.7zM416 128H32L53.2 467c1.6 25.3 22.6 45 47.9 45H346.9c25.3 0 46.3-19.7 47.9-45L416 128z"/></svg></i>
                        </button>
                    </form>
                </td>
            </tr>
                        <%
                                    }
                            }
                        %>
            </tbody>
        </table>

    </div>

</div>

<div class="details">
    <div class="recentOrders">

        <div class="cardHeader d-flex flex-row justify-content-end">
            <a href="#modal-equipment-add" data-bs-toggle="modal" class="btns">Add Equipement</a>
        </div>

        <table class="">
            <thead>
            <tr>
                <td>Name</td>
                <td>Type</td>
                <td>Quantity</td>
                <td>Operations</td>
            </tr>
            </thead>
            <tbody>
            <%
                List<Equipment> equipments = (List<Equipment>) request.getAttribute("equipments");
                if (equipments != null) {
                    for (Equipment equipment : equipments) {
            %>
            <tr>
                <td><%= equipment.getName() %>
                </td>
                <td><%= equipment.getType() %>
                </td>
                <td><%= equipment.getCount() %>
                </td>
                <td>
                    <form class="d-inline" method="POST"
                          action="${pageContext.request.contextPath}/equipment/delete">
                        <input type="hidden" name="equipmentId" value="<%=equipment.getId()%>">
                        <button class="unstyled" type="submit" style="border: none">
                            <i><svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 448 512"><!--! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. --><path d="M135.2 17.7L128 32H32C14.3 32 0 46.3 0 64S14.3 96 32 96H416c17.7 0 32-14.3 32-32s-14.3-32-32-32H320l-7.2-14.3C307.4 6.8 296.3 0 284.2 0H163.8c-12.1 0-23.2 6.8-28.6 17.7zM416 128H32L53.2 467c1.6 25.3 22.6 45 47.9 45H346.9c25.3 0 46.3-19.7 47.9-45L416 128z"/></svg></i>
                        </button>
                    </form>
                </td>

            </tr>
                        <%
                                }
                            }
                        %>
            </tbody>
        </table>

    </div>

</div>
<%@ include file="./components/Modals/add-reservation.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
<script src="https://code.iconify.des ign/iconify-icon/1.0.5/iconify-icon.min.js"></script>
<%@ include file="./components/Modals/add-equipment.jsp" %>
</body>

</html>