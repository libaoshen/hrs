/**
 * 
 */



$(function(){
	window.onload = function()
	{
		var $li = $('#tab li');
		var $ul = $('#content1 > ul');
						
		$li.click(function(){
			var $this = $(this);
			var $t = $this.index();
			$li.removeClass();
			$this.addClass('current');
			$ul.css('display','none');
			$ul.eq($t).css('display','block');
		});
		
	}
	
});

function change1(thisa){
	thisa.style.backgroundColor = "#f29d00";
}

function change2(thisa){
	thisa.style.backgroundColor = "orange";
}


