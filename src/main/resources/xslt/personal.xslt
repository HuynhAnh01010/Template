<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
                xmlns:msxsl="urn:schemas-microsoft-com:xslt" exclude-result-prefixes="msxsl js" 
                xmlns="http://www.w3.org/1999/xhtml" xmlns:js="urn:custom-javascript" 
                xmlns:ds="http://www.w3.org/2000/09/xmldsig#">
   
    <xsl:template match="/">
        <html>
            <head>
                <meta charset="UTF-8"/>
                <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
                <style>
            
                    @page{
                    margin: 0;
                    size: A4;
                    }
                    *{
                    margin: 0;
                    padding: 0;
                    }
            
                    p{
                    margin: 0px;
                    padding:0px;
                    }
            
                    body {
                    color: #000;
                    font-size: 16px;
                    width: 21cm;
                    height: 29.7cm; 
                    font-family: "Times New Roman", Times, serif;
                    margin: 0 auto;
                    line-height: 19px;
                    }
            
                    .page{
                    position: relative;
                    padding: 35px 60px 15px 70px;
                    }
                    
                    .clFix{
                    padding-left: 15px;
                    }
                    .spIcon{
                    width: 10px;
                    
                    }
                    table{
                    width: 100%;
                    }
                    .pdLeft10{
                    padding-left: 20px;
                    }
                    .tblDetail td{
                    padding:5px;
                    }
                    .tblDetail th, .tblDetail td{
                    border: 0.1px solid #000;
                    }
                    
                    .toUpper{
                    font-weight: bold;
                    }
                    
                    .toBold{
                    font-weight: bold;
                    }
                    .title2{
                    padding-top: 12px;
                    }
                   
                    
                    td.fill { float: left; overflow: hidden; white-space: nowrap }
                    
                    footer {
                    position:absolute;
                    bottom:10px;
                    }
                   
                    table.tblFooterPage{
                    font-size: 10pt;
                    width: 100%;
                    border-collapse: collapse;
                    }
                    table.tblFooterPage, table.tblFooterPage th, table.tblFooterPage td {
                    /*border: 0.1px solid black;*/
                    }
                    
                    table.tblFooterPage td{
                    padding: 10px;
                    
                    }
                    
                    .imgWatermark{
                    opacity: 0.2;
                    margin-top: 96px;
                    position: absolute;
                    margin-left: 100px;
                    width: 420px;
                    z-index: -1;

                    }
                    
                    .wrapper{
                    height: 28cm;
                    }
                    
                    .clLine{
                    text-align: center;
                    width: 100%;
                    }
                    
                    .clLine span{
                    width: 50%;
                    border-bottom: 1px solid;
                    height: 1px;
                    display: inline-block;
                    }
                    
                    table td {
                    vertical-align: top
                    }
                    input[type=checkbox] {
                    position: relative;
                    cursor: pointer;
                    }
                    input[type=checkbox]:before {
                    content: "";
                    display: block;
                    position: absolute;
                    width: 12px;
                    height: 12px;
                    top: 0;
                    left: 0;
                    border: 2px solid #555555;
                    background-color: white;
                    }
                    input[type=checkbox]:checked:after {
                    content: "";
                    width: 3px;
                    height: 9px;
                    border: solid black;
                    border-width: 0 2px 2px 0;
                    transform: rotate(45deg);
                    position: absolute;
                    top: 2px;
                    left: 6px;
                    }
                </style>
            </head>

            <body>
                <div class="page">
                    <div class="wrapper">
                        <table style="width:100%">
                            <tr>
                                <td style="width: 22%;">
                                    <img class="logo" alt="Logo" style="width: 100%;height: auto;" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAlgAAADZCAMAAADLy766AAAAAXNSR0IB2cksfwAAAAlwSFlzAAAuIwAALiMBeKU/dgAAAt9QTFRFAAAA7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0y7h0yJ553GAAAAPV0Uk5TAP9Q/gGgGAQCsNhw5yz3DND9vwPvEOgIJCD8MMAFuAYc+/jDkCjL4/OY3NuA+vkHaAo4D1Tm1/brDvILZBTu4OKoFRKI7OrhDfXp8SEJ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"/>
                                </td>
                                <td style="width: 56%">
                                    <div class="logoRight" style="text-align: center;">
                                        <p class="toUpper brandTop" style="font-weight: bold;" >CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM</p>
                                        <p class="brandUnder" style="font-size: 17px;font-weight: bold;padding-top:6px;">Độc lập - Tự do - Hạnh phúc </p>
                                        <div class="clLine">
                                            <span></span>
                                        </div>
                                    </div>
                                </td>
                                <td style="width: 22%;vertical-align: top;">
                                    <div style="width:60%;padding-right:10%;">
                                        <p style="border: 1px solid #000000;text-align:center;">DK 01</p>
                                    </div>
                                </td>
                            </tr>
                        </table>

                        <div class="content" style="position: relative;">
                            <!--img class="imgWatermark" src="data:image/png;base64,{BACKGROUD_LOGO}"></img-->
                            <div style="font-size: 17px;text-align: center;font-weight: bold;padding-top:12px;">PHIẾU YÊU CẦU DỊCH VỤ CHỨNG THƯ SỐ {CA_NAME}</div>
                            
                            <p class="title2 toBold">I. Thông tin tổ chức, doanh nghiệp</p>
                            <div class="box pdLeft10">
                                <table style="width: 100%">
                                    <!--                                    <colgroup>
                                        <col width="50%"/>
                                        <col width="50%"/>
                                    </colgroup>-->
                                    <tbody>
                                        <tr>
                                            <td colspan="2" style="height:5px;"></td>
                                        </tr>
                                        <tr>
                                            <td style="width: 100%;">Tên giao dịch đầy đủ*: <xsl:value-of select="CCTSDN/ThongTinToChuc/TenGiaoDich"/></td>
                                        </tr>
                                        <tr>
                                            <td colspan="2" style="height:5px;"></td>
                                        </tr>
                                        <tr>
                                            <td style="width: 100%;">Mã số Thuế/Mã đơn vị/Mã ngân sách*: <xsl:value-of select="CCTSDN/ThongTinToChuc/MaSoThue"/></td>
                                        </tr>
                                        <tr>
                                            <td colspan="2" style="height:5px;"></td>
                                        </tr>
                                        <tr>
                                            <td style="width: 100%;">Địa chỉ (ghi theo ĐKKD)*: <xsl:value-of select="CCTSDN/ThongTinToChuc/DiaChi"/></td>
                                        </tr>
                                    </tbody>
                                </table>
                                <table>
                                    <colgroup>
                                        <col width="75%" />
                                        <col width="25%" />
                                    </colgroup>
                                    <tbody>
                                        <tr>
                                            <td colspan="2" style="height:5px;"></td>
                                        </tr>
                                        <tr style="width: 100%;">
                                            <td style="width: 75%;">Họ tên người đại diện*: <xsl:value-of select="CCTSDN/ThongTinToChuc/HoTen"/></td>
                                            <td style="width: 25%;">Chức vụ*: <xsl:value-of select="CCTSDN/ThongTinToChuc/ChucVu"/></td>
                                        </tr>
                                    </tbody>
                                </table>
                                <table>
                                    <colgroup>
                                        <col width="50%"/>
                                        <col width="25%"/>
                                        <col width="25%" />
                                    </colgroup>
                                    <tbody>
                                        <tr>
                                            <td colspan="2" style="height:5px;"></td>
                                        </tr>
                                        <tr style="width: 100%;">
                                            <td style="width: 50%;">Số CMND/CCCD/Hộ chiếu*: <xsl:value-of select="CCTSDN/ThongTinToChuc/CMND"/></td>
                                            <td style="width: 25%;">Ngày cấp: <xsl:value-of select="CCTSDN/ThongTinToChuc/NgayCap"/></td>
                                            <td style="width: 25%;">Nơi cấp: <xsl:value-of select="CCTSDN/ThongTinToChuc/NoiCap"/></td>
                                        </tr>
                                    </tbody>
                                </table>
                                <table>
                                    <colgroup>
                                        <col width="50%" />
                                        <col width="50%" />
                                    </colgroup>
                                    <tbody>
                                        <tr>
                                            <td colspan="2" style="height:5px;"></td>
                                        </tr>
                                        <tr style="width: 100%;">
                                            <td style="width: 50%; top: 0;">Số điện thoại: <xsl:value-of select="CCTSDN/ThongTinToChuc/Mobile"/></td>
                                            <td style="width: 50%; top: 0;">Email: <xsl:value-of select="CCTSDN/ThongTinToChuc/Email"/></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
							
                            <p class="title2 toBold">II. Thông tin cá nhân/Cá nhân thuộc tổ chức, doanh nghiệp</p>
                            <div class="box pdLeft10">
                                <table style="width: 100%">
                                    <!--                                    <colgroup>
                                        <col width="50%"/>
                                        <col width="50%"/>
                                    </colgroup>-->
                                    <tbody>
                                        <tr>
                                            <td colspan="2" style="height:5px;"></td>
                                        </tr>
                                        <tr>
                                            <td style="width: 50%" >Họ và tên*: <xsl:value-of select="CCTSDN/ThongTinCaNhan/HoTen"/></td>
                                            <td style="width: 50%" >Chức vụ*: <xsl:value-of select="CCTSDN/ThongTinCaNhan/ChucVu"/></td>
                                        </tr>
                                    </tbody>
                                </table>
                                <table>
                                    <colgroup>
                                        <col width="50%" />
                                        <col width="25%" />
                                        <col width="25%" />
                                    </colgroup>
                                    <tbody>
                                        <tr>
                                            <td colspan="2" style="height:5px;"></td>
                                        </tr>
                                        <tr style="width: 100%;">
                                            <td style="width: 50%; top: 0;">Số CMND/CCCD/Hộ chiếu*: <xsl:value-of select="CCTSDN/ThongTinCaNhan/CMND"/></td>
                                            <td style="width: 25%; top: 0;">Ngày cấp*: <xsl:value-of select="CCTSDN/ThongTinCaNhan/NgayCap"/></td>
                                            <td style="width: 25%; top: 0;">Nơi cấp: <xsl:value-of select="CCTSDN/ThongTinCaNhan/NoiCap"/></td>
                                        </tr>
                                    </tbody>
                                </table>
                                <table>
                                    <tbody>
                                        <tr>
                                            <td colspan="2" style="height:5px;"></td>
                                        </tr>
                                        <tr>
                                            <td colspan="2" style="text-align: left;">Địa chỉ thường trú*: <xsl:value-of select="CCTSDN/ThongTinCaNhan/DiaChi"/></td>
                                        </tr>
                                    </tbody>
                                </table>
                                <table style="width: 100%">
                                    <colgroup>
                                        <col width="50%"/>
                                        <col width="50%"/>
                                    </colgroup>
                                    <tbody>
                                        <tr>
                                            <td colspan="2" style="height:5px;"></td>
                                        </tr>
                                        <tr style="width: 100%;">
                                            <td style="width: 50%; top: 0;">Số điện thoại: <xsl:value-of select="CCTSDN/ThongTinCaNhan/Mobile"/></td>
                                            <td style="width: 50%;top: 0;">Email: <xsl:value-of select="CCTSDN/ThongTinCaNhan/Email"/></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
							
                            <p  class="title2 toBold">III. Đối tượng sử dụng dịch vụ (*)</p>
                            <div class="box pdLeft10">
                                <table style="width: 100%">
                                    <tr>
                                        <td style="padding-top:6px;width:90px" >
                                            <input type="checkbox" disabled="disabled">
                                                <xsl:choose>
                                                    <xsl:when test="CCTSDN/DoiTuongSuDung/isCaNhan > 0">
                                                        <xsl:attribute name="checked">checked</xsl:attribute>
                                                    </xsl:when>
                                                </xsl:choose>
                                            </input> &#160;Cá nhân
                                        </td>
                                        <td  style="padding-top:6px;width:90px" >
                                            <input type="checkbox" disabled="disabled">
                                                <xsl:choose>
                                                    <xsl:when test="CCTSDN/DoiTuongSuDung/isToChuc > 0">
                                                        <xsl:attribute name="checked">checked</xsl:attribute>
                                                    </xsl:when>
                                                </xsl:choose>
                                            </input> &#160;Tổ chức
                                        </td>
                                        <td  style="padding-top:6px;width:90px" >
                                            <input type="checkbox" disabled="disabled">
                                                <xsl:choose>
                                                    <xsl:when test="CCTSDN/DoiTuongSuDung/isCaNhanThuocToChuc > 0">
                                                        <xsl:attribute name="checked">checked</xsl:attribute>
                                                    </xsl:when>
                                                </xsl:choose>
                                            </input> &#160;Cá nhân thuộc Tổ chức
                                        </td>
                                    </tr>
                                </table>
                            </div>
							
                            <p  class="title2 toBold">IV. Dịch vụ yêu cầu (*)</p>
                            <div class="box pdLeft10">
                                <table style="width: 100%">
                                    <tr>
                                        <td  style="padding-top:6px;width:90px" >
                                            <input type="checkbox" disabled="disabled">
                                                <xsl:choose>
                                                    <xsl:when test="CCTSDN/DichVuYeuCau/isCapMoi > 0">
                                                        <xsl:attribute name="checked">checked</xsl:attribute>
                                                    </xsl:when>
                                                </xsl:choose>
                                            </input> &#160;Cấp mới 
                                        </td>
                                        <td  style="padding-top:6px;width:90px" >
                                            <input type="checkbox" disabled="disabled">
                                                <xsl:choose>
                                                    <xsl:when test="CCTSDN/DichVuYeuCau/isGiaHan > 0">
                                                        <xsl:attribute name="checked">checked</xsl:attribute>
                                                    </xsl:when>
                                                </xsl:choose>
                                            </input> &#160;Gia hạn
                                        </td>
                                        <td  style="padding-top:6px;width:90px" >
                                            <input type="checkbox" disabled="disabled">
                                                <xsl:choose>
                                                    <xsl:when test="CCTSDN/DichVuYeuCau/isCapLai > 0">
                                                        <xsl:attribute name="checked">checked</xsl:attribute>
                                                    </xsl:when>
                                                </xsl:choose>
                                            </input> &#160;Cấp lại 
                                        </td>
                                    </tr>
                                    <tr>
                                        <td  style="padding-top:6px;width:90px" >
                                            <input type="checkbox" disabled="disabled">
                                                <xsl:choose>
                                                    <xsl:when test="CCTSDN/DichVuYeuCau/isTamDung > 0">
                                                        <xsl:attribute name="checked">checked</xsl:attribute>
                                                    </xsl:when>
                                                </xsl:choose>
                                            </input> &#160;Tạm dừng
                                        </td>
                                        <td  style="padding-top:6px;width:90px" >
                                            <input type="checkbox" disabled="disabled">
                                                <xsl:choose>
                                                    <xsl:when test="CCTSDN/DichVuYeuCau/isKhoiPhuc > 0">
                                                        <xsl:attribute name="checked">checked</xsl:attribute>
                                                    </xsl:when>
                                                </xsl:choose>
                                            </input> &#160;Khôi phục
                                        </td>
                                        <td  style="padding-top:6px;width:90px" >
                                            <input type="checkbox" disabled="disabled">
                                                <xsl:choose>
                                                    <xsl:when test="CCTSDN/DichVuYeuCau/isThuHoi > 0">
                                                        <xsl:attribute name="checked">checked</xsl:attribute>
                                                    </xsl:when>
                                                </xsl:choose>
                                            </input> &#160;Thu hồi
                                        </td>
                                    </tr>
                                </table>
                            </div>
							
                            <p  class="title2 toBold">V. Thời gian cấp mới/gia hạn (*)</p>
                            <div class="box pdLeft10">
                                <table style="width: 100%">
                                    <tr>
                                        <td  style="padding-top:6px;width:90px" >
                                            <input type="checkbox" disabled="disabled">
                                                <xsl:choose>
                                                    <xsl:when test="CCTSDN/ThoiGianSuDung/is1Nam > 0">
                                                        <xsl:attribute name="checked">checked</xsl:attribute>
                                                    </xsl:when>
                                                </xsl:choose>
                                            </input> &#160;1 năm
                                        </td>
                                        <td  style="padding-top:6px;width:90px" >
                                            <input type="checkbox" disabled="disabled">
                                                <xsl:choose>
                                                    <xsl:when test="CCTSDN/ThoiGianSuDung/is2Nam > 0">
                                                        <xsl:attribute name="checked">checked</xsl:attribute>
                                                    </xsl:when>
                                                </xsl:choose>
                                            </input> &#160;2 năm
                                        </td>
                                        <td  style="padding-top:6px;width:90px" >
                                            <input type="checkbox" disabled="disabled">
                                                <xsl:choose>
                                                    <xsl:when test="CCTSDN/ThoiGianSuDung/is3Nam > 0">
                                                        <xsl:attribute name="checked">checked</xsl:attribute>
                                                    </xsl:when>
                                                </xsl:choose>
                                            </input> &#160;3 năm
                                        </td>
                                        <td  style="padding-top:6px;width:90px" >
                                            <input type="checkbox" disabled="disabled">
                                                <xsl:choose>
                                                    <xsl:when test="CCTSDN/ThoiGianSuDung/is4Nam > 0">
                                                        <xsl:attribute name="checked">checked</xsl:attribute>
                                                    </xsl:when>
                                                </xsl:choose>
                                            </input> &#160;4 năm
                                        </td>
                                        <td  style="padding-top:6px;width:90px; white-space: nowrap;" >
                                            <input type="checkbox" disabled="disabled">
                                                <xsl:choose>
                                                    <xsl:when test="CCTSDN/ThoiGianSuDung/isKhac > 0">
                                                        <xsl:attribute name="checked">checked</xsl:attribute>
                                                    </xsl:when>
                                                </xsl:choose>
                                            </input> &#160;Khác: <xsl:value-of select="CCTSDN/ThoiGianSuDung/ThoiGianKhacText"/>
                                        </td>
                                    </tr>
                                </table>
                            </div>
<!--                            <p  class="title2 toBold">VI. Thiết bị sử dụng dịch vụ (*)</p>
                            <div class="box pdLeft10">
                                <table style="width: 100%">
                                    <tr>
                                        <td  style="padding-top:6px;width:90px" >
                                            <input type="checkbox" disabled="disabled">
                                                <xsl:choose>
                                                    <xsl:when test="CCTSDN/ThietBi/usbToken > 0">
                                                        <xsl:attribute name="checked">checked</xsl:attribute>
                                                    </xsl:when>
                                                </xsl:choose>
                                            </input> &#160;USB Token
                                        </td>
                                        <td  style="padding-top:6px;width:90px" >
                                            <input type="checkbox" disabled="disabled">
                                                <xsl:choose>
                                                    <xsl:when test="CCTSDN/ThietBi/HSM > 0">
                                                        <xsl:attribute name="checked">checked</xsl:attribute>
                                                    </xsl:when>
                                                </xsl:choose>
                                            </input> &#160;HSM/Server
                                        </td>
                                    </tr>
                                </table>
                            </div>-->
                            <p  class="title2">
                                <div style="width: 660px;clear: both;">
                                    <div style="width: 210px;float:left;text-align: left; font-weight:bold"> VI. Chứng thư được yêu cầu </div>
                                    <div style="width: 450px;float:left;text-align: left;">(Đối với khách hàng đã có chứng thư trên hệ thống I-CA)</div>
                                </div>		
                            </p>
                            <div class="box pdLeft10">
                                <table style="width: 100%">
                                    <tr>
                                        <td style="height:5px;"></td>
                                    </tr>
                                    <tr>
                                        <div>Số Serial chứng thư*: <xsl:value-of select="CCTSDN/CertSN"/></div>
                                    </tr>
                                </table>
                            </div>
                            <p  class="">
                                <div style="width: 660px;clear: both;">
                                    <div style="width: 110px;float:left;text-align: left; font-weight:bold"> VII. Cam kết: </div>
                                    <div style="width: 550px;float:left;text-align: left;">Chúng tôi đồng ý ủy quyền cho Nhà cung cấp sinh cặp khóa, đồng thời </div>
                                    <div style="width: 660px;float:left;text-align: left;">cam kết các thông tin khai trong bản đăng ký này là đúng sự thật và chịu hoàn toàn trách</div>
                                    <div style="width: 660px;float:left;text-align: left;">nhiệm đối với các thông tin này.</div>
                                    <div style="width: 660px;float:left;text-align: left;">Chúng tôi xác nhận đã đọc, hiểu rõ và cam kết thực hiện các điều khoản tại Quy định chung</div>
                                    <div style="width: 660px;float:left;text-align: left;">về dịch vụ được công khai trên website của I-CA tại địa chỉ <i style="text-decoration: underline;">https://i-ca.vn/quydinhdichvu</i></div>
                                </div>		
                            </p>
                            <br/>
                            <table class="tblFooterPage" style="margin-top: 6rem;">
                                <tr>
                                    <td style="margin-top: 5px; width: 50%; font-size: 10px;">
                                        <p>
                                            <strong>Hồ sơ nộp kèm:</strong>
                                        </p>
                                        <p>
                                            <i>- 01 bản chứng nhận ĐKKD/Quyết định thành lập hoặc Giấy</i>
                                            <i> chứng nhận đầu tư. Nếu MST khác với mã số ĐKKD</i>
                                            <i> thì bổ sung Đăng ký thuế.</i>
                                        </p>
                                        <p>
                                            <i>-01 bản CMND hoặc CCCD hoặc Hộ chiếu của người đại</i>
                                            <i> diện theo pháp luật.</i>
                                        </p>
                                        <p>
                                            <i>- 01 bản CMND hoặc CCCD hoặc Hộ chiếu của Cá </i>
                                            <i>nhân/Cá nhân thuộc tổ chức doanh nghiệp và Quyết định </i>
                                            <i>bổ nhiệm chức vụ đối với cá nhân thuộc tổ chức DN.</i>
                                        </p>
                                    </td>
                                    <td style="text-align: center;  width: 50%;">
                                        <p style="padding-bottom: 5px;">
                                            <xsl:value-of select="CCTSDN/ThanhPho"/>, Ngày <xsl:value-of select="CCTSDN/psNgay"/> tháng <xsl:value-of select="CCTSDN/psThang"/> năm <xsl:value-of select="CCTSDN/psNam"/>
                                        </p>
                                        <p>
                                            <strong>KHÁCH HÀNG</strong>
                                        </p>
                                        <p>
                                            <i>(Ký, ghi rõ họ tên và đóng dấu)</i>
                                        </p>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
            </body>
        </html>

    </xsl:template>
</xsl:stylesheet>