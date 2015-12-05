<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 페이지</title>

<script type="text/javascript">
	function loginCheck() {
		if (document.frm.userid.value.length == 0) {
			alert("아이디를 써주세요.");
			frm.userid.focus();
			return false;
		}

		if (document.frm.pwd.value == "") {
			alert("암호는 반드시 입력해야 합니다.");
			frm.pwd.focus();
			return false;
		}

		return ture;
	}
</script>
<link href="/JSP_Test/web-study-09/login.css" rel="stylesheet" type="text/css">

</head>
<body>

 <!-- wrap -->
<div id="login_wrap">
<!-- contents -->
<div class="contents">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="90">&nbsp;</td>
    </tr>
    <tr>
      <td height="80" align="center" valign="top"><img src="/JSP_Test/img/login_logo.jpg" width="51" height="51" align="absmiddle">&nbsp;&nbsp;&nbsp; <span class="login_title"> JSP&Servlet Login Page</span></td>
    </tr>
    <tr>
      <td height="195" align="center"><table width="560" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td height="195" align="center" class="td_line">
          
 <form id="login" action="login.do" method="post" name="frm">
 
          <!-- login box -->
          <table width="335" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="55" align="left" class="login_title_02">사용자 Login</td>
            </tr>
            <tr>
              <td height="80" align="left" valign="top"><table width="335" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="75" height="31" align="left" class="login_title_03">User ID</td>
                  <td width="182" align="left">
<%-- 로그인 아이디 입력 부분 --%>                  	
					<input type="text"name="userid" id="j_username" class="login_input">
                  </td>
                  <td width="78" rowspan="2" align="right">
<%-- 로그인 버튼 --%>
					<input type="submit" class="btn2" value="로그인" onclick="return loginCheck()" src="../img/login_btn.jpg" width="67" height="61" border="0">
					<!-- 	                  
					  <button type="submit" class="btn2">
	                  	<img src="../img/login_btn.jpg" width="67" height="61" border="0">
	                  </button> 
	                  -->
                  </td>
                </tr>
                <tr>
                  <td height="31" align="left" class="login_title_03">Password</td>
                  <td align="left">
<%-- 로그인 비밀번호 입력 부분 --%>   
                  	<input type="password" name="pwd" id="j_password" class="login_input">
                  </td>
                  </tr>
                  
                  <tr>
				<td colspan="2" align="center">
					<input type="reset" value="취소"> &nbsp;&nbsp; 
					<input type="button" value="회원 가입" onclick="location.href='join.do'">
				</td>
			</tr>
              </table></td>
            </tr>
          </table>
          <!-- // login box -->          
</form>          
          
          </td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td align="center">&nbsp;</td>
    </tr>
    <tr>
      <td align="center"><table width="520" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td height="60" align="left" class="login_text_bottom">TEM은 big data 기반 학습경험통합관리 솔루션입니다. 사용자 접속을 위해서는 접속 요청을 먼저 하셔야 합니다. 
            <p>☞ 긴급전화: 070-8224-6421 </p></td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td align="center">&nbsp;</td>
    </tr>
  </table>
</div>
<!-- contents -->
</div>
<!-- wrap -->  



</body>
</html>