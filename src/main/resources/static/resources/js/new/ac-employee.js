

// code to read selected table row cell data (values).
function showEmployeeDetails(x) {

    var name = $("#empname");
    var username = $("#empusername");
    var StartDate = $("#empstartdate");
    var empid = $("#empid");
    var col1 = $("#nm" + x).text(); // get current row 1st TD value
    var col2 = $("#un" + x).text();// get current row 2nd TD
    var col3 = $("#sd" + x).text(); // get current row 3rd TD
    name.val(col1);
    username.val(col2);
    StartDate.val(col3);
    empid.val(x);
}
