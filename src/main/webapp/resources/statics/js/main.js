jQuery(document).ready(function () {


});

//jQuery(function () {
//    jQuery("#ToChuc_NgayCap").datepicker({ dateFormat: 'dd/mm/yy' });
//});
//
//jQuery(function () {
//    jQuery("#CN_NgayCap").datepicker({ dateFormat: 'dd/mm/yy' });
//});

jQuery(function () {
    jQuery('input[name="daterangerpicker"]').daterangepicker({
        singleDatePicker: true,
        autoUpdateInput: false,
        locale: {
            cancelLabel: 'Clear',
            format: 'DD/MM/YYYY',
        },
        minYear: 1900
    });

    jQuery('input[name="daterangerpicker"]').on('apply.daterangepicker', function (ev, picker) {
        jQuery(this).val(picker.startDate.format('DD/MM/YYYY'));
    });
    jQuery('input[name="daterangerpicker"]').on('cancel.daterangepicker', function (ev, picker) {
        jQuery(this).val('');
    });
});


let ThoiHanSuDung = document.getElementById("ThoiHanSuDung");
if (ThoiHanSuDung) {
    Object.values(ThoiHanSuDung.children).map(el => {
        el.onkeydown = function (e) {
            handleChange(el.name, el, e);
        }
    });
}

function handleChange(id, element, e) {
    element.value.length === 0
            && e.keys === "Backspace"
            && element.previousElementSibling
            && element.previousElementSibling.focus()

    element.value.length === element.maxLength
            && e.key !== "Backspace"
            && element.nextElementSibling
            && element.nextElementSibling.focus()
}


let sendPersonInfoXslt = function () {
    let fullTimes = document.getElementById("ToChuc_NgayCap").value;
    console.log(fullTimes);

    let fullTimes2 = document.getElementById("CN_NgayCap").value;
    console.log(fullTimes2);

//    console.log("FullTimes: ", fullTimes);

    let checktext = document.getElementById("other-year").value;
    let checkvalue;
    if (checktext == 1) {
        checkvalue = document.getElementById("other-year-text").value;
    } else {
        checkvalue = "";
    }
    
    let date = jQuery("#NgayThangNam").val();
    let dateFull = date.split('/');
    let ngay;
    let thang;
    let nam;
    
    if(date) {
        ngay = dateFull[0];
        thang = dateFull[1];
        nam = dateFull[2];
    } else if (!date) {
        ngay = ".....";
        thang = ".....";
        nam = ".....";
    }
    
    let thanhPho = jQuery("#ThanhPho").val();
    let thanhPhoFull;
    if(thanhPho) {
        thanhPhoFull = thanhPho;
    } else if (!thanhPho) {
        thanhPhoFull = "...............";
    }

    let data = {
        tochuc_TenGiaoDich: jQuery("#ToChuc_TenGiaoDich").val(),
        tochuc_MST: jQuery("#ToChuc_MST").val(),
        tochuc_DiaChi: jQuery("#ToChuc_DiaChi").val(),
        tochuc_HoTen: jQuery("#ToChuc_HoTen").val(),
        tochuc_ChucVu: jQuery("#ToChuc_ChucVu").val(),
        tochuc_CMND: jQuery("#ToChuc_CMND").val(),
        tochuc_NgayCap: fullTimes,
        tochuc_NoiCap: jQuery("#ToChuc_NoiCap").val(),
        tochuc_SDT: jQuery("#ToChuc_SDT").val(),
        tochuc_Email: jQuery("#ToChuc_Email").val(),

        canhan_HoTen: jQuery("#CaNhan_HoTen").val(),
        canhan_ChucVu: jQuery("#CaNhan_ChucVu").val(),
        canhan_CMND: jQuery("#CaNhan_CMND").val(),
        canhan_NgayCap: fullTimes2,
        canhan_NoiCap: jQuery("#CaNhan_NoiCap").val(),
        canhan_DiaChi: jQuery("#CaNhan_DiaChi").val(),
        canhan_SDT: jQuery("#CaNhan_SDT").val(),
        canhan_Email: jQuery("#CaNhan_Email").val(),

        canhan: document.getElementById("personal").value,
        tochuc: document.getElementById("company").value,
        canhanTtochuc: document.getElementById("per-company").value,

        capmoi: document.getElementById("new-issue").value,
        giahan: document.getElementById("extend").value,
        caplai: document.getElementById("renew").value,
        tamdung: document.getElementById("stop").value,
        khoiphuc: document.getElementById("restore").value,
        thuhoi: document.getElementById("recall").value,

        motnam: document.getElementById("1-year").value,
        hainam: document.getElementById("2-year").value,
        banam: document.getElementById("3-year").value,
        bonnam: document.getElementById("4-year").value,
        khac: document.getElementById("other-year").value,
        khacText: checkvalue,

//        usbToken: document.getElementById("usb").value,
//        hsm: document.getElementById("hsm").value,
        series_CTS: document.getElementById("serial_cts").value,
        psThanhPho: thanhPhoFull,
        psNgay: ngay,
        psThang: thang,
        psNam: nam
    };

    jQuery.ajax({
        url: 'personal',
        data: JSON.stringify(data),
        processData: false,
        type: 'POST',
        contentType: 'application/json',
        success: function (res) {
//            console.log("SUCCESS: ", res);
            PrintPreview(res)
        },
        error: function (err) {
//            console.log("ERROR: ", err);
        }
    });
};



let sendConfirInfoXslt = function () {
    
    let date = jQuery("#cf_Ngay").val();
    let dateFull = date.split('/');
    let day;
    let month;
    let year;
    
    if (date) {
        day = dateFull[0];
        month = dateFull[1];
        year = dateFull[2];
    }
    else if (!date) {
        day = ".....";
        month = ".....";
        year = ".....";
    }

    let data = {
        cfNgay: day,
        cfThang: month,
        cfNam: year,
        tenKhachHang: jQuery("#KH_KhachHang").val(),
        maSoThue: jQuery("#KH_MaSoThue").val(),
        diaChi: jQuery("#KH_DiaChi").val(),
        sdt: jQuery("#KH_SDT").val(),
        hoTen: jQuery("#KH_HoTen").val(),
        chucVu: jQuery("#KH_ChucVu").val(),
        series_cts: jQuery("#series_CTS").val(),
//        tbpc: jQuery("#ThietBiPhanCung").val(),
        tgiansd: jQuery("#ThoiHanSuDung").val(),
        subject_DN: jQuery("#Subject_DN").val(),
        issuer_DN:jQuery("#Issuer_DN").val()
    }

    jQuery.ajax({
        url: 'confirmation',
        data: JSON.stringify(data),
        processData: false,
        type: 'POST',
        contentType: 'application/json',
        success: function (res) {
//            console.log("SUCCESS: ", res);
            PrintPreview(res)
        },
        error: function (err) {
//            console.log("ERROR: ", err);
        }
    });
};

let sendCertiInfoXslt = function () {
//    console.log("click");
    let data = {
        hoten: jQuery("#hoten").val(),
        mst: jQuery("#mst").val(),
        cmndhc: jQuery("#cmndhc").val(),
        certSN: jQuery("#certSN").val(),
        tenKHCu: jQuery("#tenKHCu").val(),
        tenKHMoi: jQuery("#tenKHMoi").val(),
        cmndHCCu: jQuery("#cmndHCCu").val(),
        cmndHCMoi: jQuery("#cmndHCMoi").val(),
        diachiCu: jQuery("#diachiCu").val(),
        diachiMoi: jQuery("#diachiMoi").val(),
        khacCu: jQuery("#khacCu").val(),
        khacMoi: jQuery("#khacMoi").val(),
        ttHoten: jQuery("#ttHoten").val(),
        ttChucvu: jQuery("#ttChucvu").val(),
        ttSdt: jQuery("#ttSdt").val(),
        ttEmail: jQuery("#ttEmail").val()
    }

    jQuery.ajax({
        url: 'change-certificate',
        data: JSON.stringify(data),
        processData: false,
        type: 'POST',
        contentType: 'application/json',
        success: function (res) {
//            console.log("SUCCESS: ", res);
            PrintPreview(res)
        },
        error: function (err) {
//            console.log("ERROR: ", err);
        }
    });
};

function PrintPreview(vText) {
    var popupWin = window.open('', '_blank', 'width=850,height=900,left=200px,location=1,resizable=1, directories=1, toolbar=1');
    popupWin.document.open();
    popupWin.document.write('<html><title></title><link rel="stylesheet" type="text/css" href="Print.css" media="screen"/></head><body onload="window.print()">');
    popupWin.document.write(vText);
    popupWin.document.write('</html>');
    popupWin.document.close();
}

let reload = function () {
    let n = 1;
    console.log(":", n++);
    let TenToChuc = document.getElementById("TenToChuc");
    let MST = document.getElementById("MST");
    let tcDiaChi = document.getElementById("tcDiaChi");
    let Hoten = document.getElementById("HoTen");
    jQuery('input[type=checkbox]').each(function ()
    {
        this.checked = false;
        this.value = 0;
    });
    jQuery('input[type=text]').each(function ()
    {
        this.value = "";
    });
    jQuery('input[type=email]').each(function ()
    {
        this.value = "";
    });
    if (TenToChuc) {
        if (TenToChuc.value) {
            TenToChuc.value = "";
            MST.value = "";
            tcDiaChi.value = "";
            Hoten.value = "";

        }

    }
    let  taxCode = document.getElementById("taxCode");
    let rePresentive = document.getElementById("rePresentive");
    let customName = document.getElementById("customerName");
    if (taxCode) {
        if (taxCode.value) {
            taxCode.value = "";
            rePresentive.value = "";
            customName.value = "";
        }

    }

    let mst = document.getElementById("mst");
    let nameCompa = document.getElementById("hoten");
    if (mst) {
        if (mst.value) {
            mst.value = "";
            nameCompa.value = "";
        }

    }

}



jQuery("#other-year").click(function () {
    if (jQuery(this).is(':checked')) {
        document.getElementById("other-year-text").disabled = false;
    } else {
        document.getElementById("other-year-text").disabled = true;
    }
});

let searchMST = function () {
    let idSearchMST = document.getElementById("searchMST").value;
//    console.log("MST: ", idSearchMST);

    let data = {
        tax_code: idSearchMST
    }

    let displayInfo = document.getElementById("search-body-info");
    let displayChoose = document.getElementById("search-body-choosedk");
    let infoCompany = document.getElementById("infoCompany");
    let infoTaxCode = document.getElementById("infoTaxCode");
    let infoAddress = document.getElementById("infoAddress");
    let infoPresentativeName = document.getElementById("infoPresentativeName");
    let nameWorld = document.getElementById("nameWorld");
    let nameVT = document.getElementById("nameVT");
    let infoMobile = document.getElementById("infoMobile");
    let infoEmail = document.getElementById("infoEmail");


    displayInfo.style.display = "none";
    displayChoose.style.display = "none";

    jQuery.ajax({
        url: 'search',
//        url: 'searchCompany',
        data: JSON.stringify(data),
        processData: false,
        type: 'POST',
        contentType: 'application/json',
        success: function (res) {
//            console.log("Success!!!", res);
            displayInfo.style.display = "block";
            displayChoose.style.display = "block";

            infoCompany.innerHTML = res.body.data.Title;
            infoTaxCode.innerHTML = res.body.data.MaSoThue;
            infoAddress.innerHTML = res.body.data.DiaChiCongTy;
            infoPresentativeName.innerHTML = res.body.data.GiamDoc;
            if (res.body.data.TitleEn) {
                nameWorld.innerHTML = res.body.data.TitleEn;
            }
            if (res.body.data.TenVietTat) {
                nameVT.innerHTML = res.body.data.TenVietTat;
            }
            if (res.body.data.SoDienThoai) {
                infoMobile.innerHTML = res.body.data.SoDienThoai;
            }
            if (res.body.data.Email) {
                infoEmail.innerHTML = res.body.data.Email;
            }

        },
        error: function (err) {
            console.log("ERROR: ", err);
            displayInfo.style.display = "none";
            displayChoose.style.display = "none";
        }
    });
}

let searchTaxCode = function () {
    let taxCode = document.getElementById("taxCodeSearch").value;
    console.log("TAX CODE: ", taxCode);

    let data = {
        tax_code: taxCode
    }

    let checkPersonal = document.getElementById("div-personal");
    let tenGiaoDich = document.getElementById("ToChuc_TenGiaoDich");
    let maSoThue = document.getElementById("ToChuc_MST");
    let diaChi = document.getElementById("ToChuc_DiaChi");
    let hoTen = document.getElementById("ToChuc_HoTen");
    let ToChuc_ChucVu = document.getElementById("ToChuc_ChucVu");
    let ToChuc_CMND = document.getElementById("ToChuc_CMND");
    let ToChuc_NoiCap = document.getElementById("ToChuc_NoiCap");
    let ToChuc_SDT = document.getElementById("ToChuc_SDT");
    let ToChuc_Email = document.getElementById("ToChuc_Email");

//    ---
    let checkConfirmation = document.getElementById("div-confirmation");
    let customerName = document.getElementById("KH_KhachHang");
    let taxCodeMST = document.getElementById("KH_MaSoThue");
    let confirm_address = document.getElementById("KH_DiaChi");
    let confirm_sdt = document.getElementById("KH_SDT");
    let confirm_hoten = document.getElementById("KH_HoTen");
    let confirm_chucvu = document.getElementById("KH_ChucVu");

//    ---
    let checkCertificate = document.getElementById("div-certificate");
    let mst = document.getElementById("mst");
    let nameCOmpa = document.getElementById("hoten");

    jQuery.ajax({
        url: 'search',
        data: JSON.stringify(data),
        processData: false,
        type: 'POST',
        contentType: 'application/json',
        success: function (res) {
            console.log("SUCCESS: ", res);
            if (checkPersonal) {
                tenGiaoDich.value = res.body.data.Title;
                maSoThue.value = res.body.data.MaSoThue;
                diaChi.value = res.body.data.DiaChiCongTy;
                hoTen.value = res.body.data.GiamDoc;
                if (res.body.data.ChucVu) {
                    ToChuc_ChucVu.value = res.body.data.ChucVu;
                }
            }
            if (checkConfirmation) {
                customerName.value = res.body.data.Title;
                taxCodeMST.value = res.body.data.MaSoThue;
                confirm_address.value = res.body.data.DiaChiCongTy;
                if (confirm_sdt) {
                    confirm_sdt.value = res.body.data.SoDienThoai;
                }
                confirm_hoten.value = res.body.data.GiamDoc;
                if (confirm_chucvu) {
                    confirm_chucvu.value = res.body.data.ChucVu;
                }
            }
            if (checkCertificate) {
                mst.value = res.body.data.MaSoThue;
                nameCOmpa.value = res.body.data.Title;
            }
        },
        error: function (err) {
            console.log("ERROR: ", err);
        }
    });

}



