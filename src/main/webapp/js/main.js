

$(function(){


	$("#submit").click(function(){

		var txt_question_1 = $("#txt_question_1").val();
		var txt_question_2 = $("#txt_question_2").val();
		var txt_question_3 = $("#txt_question_3").val();
		var txt_question_4 = $("#txt_question_4").val();
		var txt_question_5 = $("#txt_question_5").val();
		var txt_question_6 = $("#txt_question_6").val();
		var txt_question_7 = $("#txt_question_7").val();
		var txt_question_8 = $("#txt_question_8").val();
		$.ajax({ 
			url: "/out-pkg-qa/moier/welcome/question", 
			data:{
				t1:txt_question_1,
				t2:txt_question_2,
				t3:txt_question_3,
				t4:txt_question_4,
				t5:txt_question_5,
				t6:txt_question_6,
				t7:txt_question_7,
				t8:txt_question_8
			},
			type:"POST",
			success: function(data){
				if(data.success) {
					$('.question').hide();
					$('.submit-success').show();
				}else{
					alert(data.info);
				}
			}
		});


	});
});
