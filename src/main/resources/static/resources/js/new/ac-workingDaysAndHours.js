

// code to read selected table row cell data (values).
function showWorkingDayDetails(day, hour, season) {


    var daySelected = $("#dow" + day).text();
    var dayTypeSelected = $("#dtype" + day).text();
    var startHourSelected = $("#ot" + hour).text();
    var EndHourSelected = $("#ct" + hour).text();
    var dayOfWeekToEdit = $("#dayOfWeek");
    var startingHourToEdit = $("#startingHour");
    var closeHourToEdit = $("#closeHour");
    var dayId = $("#dayid");
    var hoursId = $("#whid");
    var dayName = $("#dayName");
    var dayOfWeekName = document.getElementById("dayOfWeekName");
    var seasonId = $("#seasonId");
    dayOfWeekToEdit.val(daySelected);
    startingHourToEdit.val(startHourSelected);
    closeHourToEdit.val(EndHourSelected);

    dayName.val(daySelected);
    dayOfWeekName.innerHTML = "Day : " + daySelected;

    if (dayTypeSelected === "Work") {
        yesBtn = document.getElementById('choice1');

//  Set the radio button to checked
        yesBtn.checked = true;
    } else {
        noBtn = document.getElementById('choice2');
//  Set the radio button to checked
        noBtn.checked = true;
    }
    dayId.val(day);
    hoursId.val(hour);
    seasonId.val(season);

}
