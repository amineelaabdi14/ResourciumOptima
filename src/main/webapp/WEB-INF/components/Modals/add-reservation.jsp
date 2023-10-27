<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- MODAL -->
<div class="modal fade" id="modal-reservation-add" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true" >
  <div class="modal-dialog">
    <div class="modal-content">
      <form action="reservation/add" method="POST" id="form" >


        <div class="modal-header">
          <h5 class="modal-title" id="modal-title">Make Reservation</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">

          <div class="mb-3">
            <label class="form-label" >Equipement</label>
            <select name="equipmentId"  class="form-select" aria-label="Default select example">
              <option selected disabled>Open this select menu</option>
              <%
                for (Equipment equipment : equipments) {
              %>
              <option value="<%= equipment.getId() %>"><%= equipment.getName()  %></option>
              <%
                }
              %>

            </select>
          </div>
          <div class="mb-3">
            <label class="form-label">Reservation Date</label>
            <input type="date" class="form-control" name="reservationDate">
          </div>
          <div class="mb-3">
            <label class="form-label">Return Date</label>
            <input type="date" class="form-control" name="returnDate">
          </div>


        </div>

        <div class="modal-footer">
          <button type="button" data-bs-dismiss="modal" class="btn btn-secondary" >Cancel</button>
          <button type="submit" name="save" class="btn btn-primary task-action-btn" id="save">Save</button>
        </div>
      </form>
    </div>
  </div>
</div>