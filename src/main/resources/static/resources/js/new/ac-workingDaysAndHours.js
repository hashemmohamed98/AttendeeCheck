

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
    var hoursDayId = $("#whdayid");
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
    hoursDayId.val(day);

}


function submitFormDetails() {
    var table = document.getElementById('dataTable');
    console.log("TABLE SIZE = " + table.rows.length);
    var myData = [];

    for (var r = 0, n = table.rows.length - 1; r < n; r++) {

        var dayType = $("input[type='radio'][name='workDay" + r + "'" + "]:checked").val();
        var workDay;
        if (dayType === '1') {
            workDay = true;


        } else
            workDay = false;
        var hour = {
            openTime: $("#startingHour" + r).val(),
            closeTime: $("#closeHour" + r).val()
        };
        var day = {dayOfWeek: ($("#day" + r).text()),
            workDay: workDay,
            workingHours: hour,
            season: {id: $("#season").val()}
        };
        myData.push(day);
    }

    console.log(myData);
    $.ajax({

        url: '/administration/workingdays/add',
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(myData),
        dataType: "text",
        processData: false,
        cache: false,
        success: function (dataRecord) {
            swal({
                title: "Done",
                text: "Working Days & Hours Added Successfully",
                type: "success"
            });
            $("#submitBtn").addClass("d-none");

        },
        error: function (error) {
            swal({
                title: "Error",
                text: "Error Occurred While Adding Image",
                type: "warning"
            });
        }

    });
}


function ShowFormTable() {

    if ($("#season").val() !== "") {

        $("#season_form").removeClass("d-none");

    }

}

