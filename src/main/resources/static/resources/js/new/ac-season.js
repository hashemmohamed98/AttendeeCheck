

// code to read selected table row cell data (values).
function showSeasonDetails(x) {

    var name = $("#seasonname");
    var active = $("#seasonactive");
    var StartDate = $("#seasonstartdate");
    var endDate = $("#seasonenddate");
    var sid = $("#sid");
    var col1 = $("#nm" + x).text(); // get current row 1st TD value
    var col2 = $("#sd" + x).text();// get current row 2nd TD
    var col3 = $("#ed" + x).text(); // get current row 3rd TD
    var col4 = $("#act" + x).text();
    name.val(col1);
    StartDate.val(col2);
    endDate.val(col3);

    if (col4 === "true") {
        yesBtn = document.getElementById('choice1');

//  Set the radio button to checked
        yesBtn.checked = true;
    } else {
        noBtn = document.getElementById('choice2');
//  Set the radio button to checked
        noBtn.checked = true;
    }
    console.log(active.val());
    sid.val(x);
}
