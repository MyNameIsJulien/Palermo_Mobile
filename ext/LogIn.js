
			$(document).ready(function(){
				loginname = null;
				loginpassword = null;

				//Patchnotes
				$.ajax({url: "patchnotes.php", success: function(msg){ $('#patchnotesdiv').html(msg); }});

				//Rolesdiv
				role = "M\u00f6rder";
				$.ajax({url: "response.php", type: "POST", data: "response=rolesindex&role="+role, success: function(msg){
					$('#rolesdiv').html(msg);
				}});



				//Registrierung
				$('#register').submit(function(){
					try{
						if($("#registername").val() == "" || $("#registerpassword").val() == "" || $("#registerpassword2").val() == "" || $("#registeremail").val() == ""){
							$("#registerpasswordresponse").html("<font color = '#d9534f'>Feld ausgelassen.</font>");
						} else if($("#registerpassword").val() != $("#registerpassword2").val()){
							$("#registerpasswordresponse").html("<font color = '#d9534f'>Passwörter ungleich.</font>");
							$("#registerpassword").val("");
							$("#registerpassword2").val("");
						} else if($("#registername").val().length < 3){
							$("#registernameresponse").html("<font color = '#d9534f'>Min 3 Zeichen</font>");
						} else if(!($("#registeremail").val().indexOf("@") != -1 && $("#registeremail").val().indexOf(".") != -1)){
							$("#registeremailresponse").html("<font color = '#d9534f'>Ungültiges Email Format</font>");
						} else if($("#registername").val() != "Bot%"){
							$("#registerpasswordresponse").html("Registrierung...");
							$.ajax({type: "POST", url: "register2.php", data: "registername=" + $("#registername").val() + "&registerpassword=" + $("#registerpassword").val() + "&registeremail=" + $("#registeremail").val() + "&recruiter=" + $("#recruiter").val(), success: function(msg){
								$("#registerpasswordresponse").html(msg);
							}});
							return false;
						}

						return false;
					} catch (e) {
						window.alert(e.message);
						return false;
					}
				});

				$('#registername').keyup(function(){
					var regstring = $(this).val();
					if(regstring.length > 2){
						$.ajax({type: "POST", url: "response.php", data: "what=" + regstring + "&response=register", success: function(msg){
							//Gefundene Ergebnisse in div clientsearchblock
							$('#registernameresponse').html(msg);
						}});
						$('#registernameresponse').show();
					}
					else if(regstring.length > 0){
						$('#registernameresponse').html("<font color = '#d9534f'>Min 3 Zeichen</font>");
						$('#registernameresponse').show();
					}
					else{
						$('#registernameresponse').hide();
						$('#registerpasswordresponse').hide();
					}
				});

				//Login
				$('#login').click(function(){
					var loginname = $('#loginname').val();
					var loginpassword = $('#loginpassword').val();
					var staylogged = $('#staylogged').val();
					$.ajax({type: "POST", url: "login.php", data: "send=" + true + "&loginname=" + loginname + "&loginpassword=" + loginpassword + "&staylogged=" + staylogged, success: function(msg){
						$('#loginresponse').html(msg);
					}});
					return false;
				});
				$('#loginname').keyup(function(){
					$('#loginresponse').html('');
				});
				$('#loginpassword').keyup(function(){
					$('#loginresponse').html('');
				});
				$('#ForgotPasswordButton').click(function(){
					$.ajax({type: "GET", url: "password.php", success: function(msg){
						$('#IndexMainContainer').html(msg);
					}});
					return false;
				});
			});
