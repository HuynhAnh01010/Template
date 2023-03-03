jQuery(document).ready(function () {
    let personal = document.getElementById("personal");
    let company = document.getElementById("company");
    let per_company = document.getElementById("per-company");

    jQuery('#personal').click(function () {
        company.checked = false;
        per_company.checked = false;
        company.value = 0;
        per_company.value = 0;
        if (personal.value == 1) {
            personal.value = 0;
        } else {
            personal.value = 1;
        }

    });

    jQuery('#company').click(function () {
        personal.checked = false;
        per_company.checked = false;
        personal.value = 0;
        per_company.value = 0;
        if (company.value == 1) {
            company.value = 0;
        } else {
            company.value = 1;
        }
    });

    jQuery('#per-company').click(function () {
        company.checked = false;
        personal.checked = false;
        personal.value = 0;
        company.value = 0;
        if (per_company.value == 1) {
            per_company.value = 0;
        } else {
            per_company.value = 1;
        }
    });

    let new_issue = document.getElementById("new-issue");
    let extend = document.getElementById("extend");
    let renew = document.getElementById("renew");
    let stop = document.getElementById("stop");
    let restore = document.getElementById("restore");
    let recall = document.getElementById("recall");

    jQuery("#new-issue").click(function () {
        extend.checked = false;
        renew.checked = false;
        stop.checked = false;
        restore.checked = false;
        recall.checked = false;
        extend.value = 0;
        renew.value = 0;
        stop.value = 0;
        restore.value = 0;
        recall.value = 0;
        if (new_issue.value == 1) {
            new_issue.value = 0;
        } else {
            new_issue.value = 1;
        }
    });

    jQuery("#extend").click(function () {
        new_issue.checked = false;
        renew.checked = false;
        stop.checked = false;
        restore.checked = false;
        recall.checked = false;
        new_issue.value = 0;
        if (extend.value == 1) {
            extend.value = 0;
        } else {
            extend.value = 1;
        }
        renew.value = 0;
        stop.value = 0;
        restore.value = 0;
        recall.value = 0;
    });

    jQuery("#renew").click(function () {
        new_issue.checked = false;
        extend.checked = false;
        stop.checked = false;
        restore.checked = false;
        recall.checked = false;
        new_issue.value = 0;
        extend.value = 0;
        if (renew.value == 1) {
            renew.value = 0;
        } else {
            renew.value = 1;
        }
        stop.value = 0;
        restore.value = 0;
        recall.value = 0;
    });

    jQuery("#stop").click(function () {
        new_issue.checked = false;
        extend.checked = false;
        renew.checked = false;
        restore.checked = false;
        recall.checked = false;
        new_issue.value = 0;
        extend.value = 0;
        renew.value = 0;
        if (stop.value == 1) {
            stop.value = 0;
        } else {
            stop.value = 1;
        }
        restore.value = 0;
        recall.value = 0;
    });

    jQuery("#restore").click(function () {
        new_issue.checked = false;
        extend.checked = false;
        renew.checked = false;
        stop.checked = false;
        recall.checked = false;
        new_issue.value = 0;
        extend.value = 0;
        renew.value = 0;
        stop.value = 0;
        if (restore.value == 1) {
            restore.value = 0;
        } else {
            restore.value = 1;
        }
        recall.value = 0;
    });

    jQuery("#recall").click(function () {
        new_issue.checked = false;
        extend.checked = false;
        renew.checked = false;
        stop.checked = false;
        restore.checked = false;
        new_issue.value = 0;
        extend.value = 0;
        renew.value = 0;
        stop.value = 0;
        restore.value = 0;
        if (recall.value == 1) {
            recall.value = 0;
        } else {
            recall.value = 1;
        }

    });


    let oneyear = document.getElementById("1-year");
    let twoyear = document.getElementById("2-year");
    let threyear = document.getElementById("3-year");
    let foryear = document.getElementById("4-year");
    let otheryear = document.getElementById("other-year");


    jQuery("#1-year").click(function () {
        twoyear.checked = false;
        threyear.checked = false;
        otheryear.checked = false;
        foryear.checked = false;
        if (oneyear.value == 1) {
            oneyear.value = 0;
        } else {
            oneyear.value = 1;
        }
        twoyear.value = 0;
        threyear.value = 0;
        foryear.value = 0;
        otheryear.value = 0;
    });

    jQuery("#2-year").click(function () {
        oneyear.checked = false;
        threyear.checked = false;
        otheryear.checked = false;
        foryear.checked = false;
        oneyear.value = 0;
        if (twoyear.value == 0) {
            twoyear.value = 1;
        } else {
            twoyear.value = 0;
        }
        threyear.value = 0;
        foryear.value = 0;
        otheryear.value = 0;
    });

    jQuery("#3-year").click(function () {
        twoyear.checked = false;
        oneyear.checked = false;
        otheryear.checked = false;
        foryear.checked = false;
        oneyear.value = 0;
        twoyear.value = 0;
        if (threyear.value == 0) {
            threyear.value = 1;
        } else {
            threyear.value = 0;
        }
        foryear.value = 0;
        otheryear.value = 0;
    });

    jQuery("#4-year").click(function () {
        twoyear.checked = false;
        oneyear.checked = false;
        otheryear.checked = false;
        threyear.checked = false;
        oneyear.value = 0;
        twoyear.value = 0;
        threyear.value = 0;
        if (foryear.value == 0) {
            foryear.value = 1;
        } else {
            foryear.value = 0;
        }
        otheryear.value = 0;
    });

    jQuery("#other-year").click(function () {
        twoyear.checked = false;
        threyear.checked = false;
        oneyear.checked = false;
        foryear.checked = false;
        oneyear.value = 0;
        twoyear.value = 0;
        threyear.value = 0;
        foryear.value = 0;
        if (otheryear.value == 0) {
            otheryear.value = 1;
        } else {
            otheryear.value = 0;
        }
    });

//    let usb = document.getElementById("usb");
//    let hsm = document.getElementById("hsm");
//
//    jQuery("#usb").click(function () {
//        hsm.checked = false;
//        if (usb.value == 0) {
//            usb.value = 1;
//        } else {
//            usb.value = 0;
//        }
//        hsm.value = 0;
//    });
//
//    jQuery("#hsm").click(function () {
//        usb.checked = false;
//        usb.value = 0;
//        if (hsm.value == 0) {
//            hsm.value = 1;
//        } else {
//            hsm.value = 0;
//        }
//    });

    if (personal) {
        if (personal.checked == false) {
            personal.value = 0;
        }
        if (company.checked == false) {
            company.value = 0;
        }
        if (per_company.checked == false) {
            per_company.value = 0;
        }
        if (new_issue.checked == false) {
            new_issue.value = 0;
        }
        if (extend.checked == false) {
            extend.value = 0;
        }
        if (renew.checked == false) {
            renew.value = 0;
        }
        if (stop.checked == false) {
            stop.value = 0;
        }
        if (restore.checked == false) {
            restore.value = 0;
        }
        if (recall.checked == false) {
            recall.value = 0;
        }
        if (oneyear.checked == false) {
            oneyear.value = 0;
        }
        if (twoyear.checked == false) {
            twoyear.value = 0;
        }
        if (threyear.checked == false) {
            threyear.value = 0;
        }
        if (foryear.checked == false) {
            foryear.value = 0;
        }
        if (otheryear.checked == false) {
            otheryear.value = 0;
        }
//        if (usb.checked == false) {
//            usb.value = 0;
//        }
//        if (hsm.checked == false) {
//            hsm.value = 0;
//        }
    }
});




