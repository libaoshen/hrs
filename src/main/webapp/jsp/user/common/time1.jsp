<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<title>Date Picker Demo</title>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/common/time/daterangepicker1.min.css" />
		
		<script src="<%=request.getContextPath()%>/js/common/time/moment.min.js" type="text/javascript"></script>
		<script src="<%=request.getContextPath()%>/js/common/time/jquery.daterangepicker.min.js"></script>
		
		<style type="text/css">
		#wrapper
		{
			width:500px;
			margin:0 auto;
			color:#333;
            font-family:Tahoma,Verdana,sans-serif;
			line-height:1.5;
			font-size:14px;
			z-index:999999;
		}
		.demo { margin:30px 0;}
		.date-picker-wrapper .month-wrapper table .day.lalala { background-color:orange; }
		.options { display:none; border-left:6px solid #8ae; padding:10px; font-size:12px; line-height:1.4; background-color:#eee; border-radius:4px;}
		.date-picker-wrapper.date-range-picker19 .day.first-date-selected { background-color: red !important; }
		.date-picker-wrapper.date-range-picker19 .day.last-date-selected { background-color: orange !important; }
		</style>
	</head>
	<body>
		
		<div id="wrapper">
		
		<div style="display:none">
			<div class="demo">
			
				Default settings: <input id="date-range0" size="40" value="">
				<a href="#" class="show-option">Show Config</a>
				<pre class="options">
{}</pre>
			</div>

			<div>
				Default settings with time enabled: <input id="date-range1" size="60" value="">
				<a href="#" class="show-option">Show Config</a>
				<pre class="options">
{
	startOfWeek: 'monday',
	separator : ' ~ ',
	format: 'DD.MM.YYYY HH:mm',
	autoClose: false,
	time: {
		enabled: true
	}
}</pre>
			</div>



			<div class="demo">
				Default settings with default start/end time value: <input id="date-range1-1" size="60" value="">
				<a href="#" class="show-option">Show Config</a>
				<pre class="options">
{
	startOfWeek: 'monday',
	separator : ' ~ ',
	format: 'DD.MM.YYYY HH:mm',
	autoClose: false,
	time: {
		enabled: true
	},
	defaultTime: moment().startOf('day').toDate(),
	defaultEndTime: moment().endOf('day').toDate()
}</pre>
			</div>

			<div class="demo">
				Default settings with default value: <input id="date-range2" size="40" value="2013-10-01 to 2013-11-04">
				<a href="#" class="show-option">Show Config</a>
				<pre class="options">
{}</pre>
			</div>

			<div class="demo">
				Force to Chinese: <input id="date-range3" size="40" value="">
				<a href="#" class="show-option">Show Config</a>
				<pre class="options">
{
	language:'cn'
}</pre>
			</div>

			<div class="demo">
				Force to English: <input id="date-range4" size="40" value="">
				<a href="#" class="show-option">Show Config</a>
				<pre class="options">
{
	language:'en'
}				</pre>
			</div>

			<div class="demo">
				Use custom language: <input id="date-range4-1" size="40" value="">
				<a href="#" class="show-option">Show Config</a>
				<pre class="options">
{
	language: 'custom'
}			</pre>
			</div>

			<div class="demo">
				Select a date range after 2014-11-20: <input id="date-range5" size="40" value="">
				<a href="#" class="show-option">Show Config</a>
				<pre class="options">
{
	startDate: '2014-11-20'
}				</pre>
			</div>

			<div class="demo">
				Limit date range selected between 3 days to 7 days: <input id="date-range5-2" size="40" value="">
				<a href="#" class="show-option">Show Config</a>
				<pre class="options">
{
	maxDays: 7,
	minDays: 3
}				</pre>
			</div>

			<div class="demo">
				Select a date range between 2013-01-10 to 2013-02-10: <input id="date-range6" size="40" value="">
				<a href="#" class="show-option">Show Config</a>
				<pre class="options">
{
	startDate: '2013-01-10',
	endDate: '2013-02-10'
}				</pre>
			</div>

			<div class="demo">
				Select a date range between 3 days and 7 days: <input id="date-range7" size="40" value="">
				<a href="#" class="show-option">Show Config</a>
				<pre class="options">
{
	minDays: 3,
	maxDays: 7
}			</pre>
			</div>

			<div class="demo">
				Set start of week to Monday: <input id="date-range8" size="40" value="">
				<a href="#" class="show-option">Show Config</a>
				<pre class="options">
{
	startOfWeek: 'monday'
}			</pre>
			</div>

			<div class="demo">
				Use SPAN instead of INPUT: <span id="date-range9" style="background-color:#49e; color:white;padding:3px; cursor:pointer; border-radius:4px;">select</span>
				<a href="#" class="show-option">Show Config</a>
				<pre class="options">
{
	getValue: function()
	{
		return this.innerHTML;
	},
	setValue: function(s)
	{
		this.innerHTML = s;
	}
}				</pre>
			</div>
</div>



			<div class="demo">
				入住时间 <span id="two-inputs"><input id="date-range200" size="20" value="">  &nbsp;&nbsp; 退房时间 <input id="date-range201" size="20" value=""></span>
			</div>
			
			
			
			
<div style="display:none;">
			<div class="demo">
				Use another date format: <input id="date-range10" size="60" value="">
				<a href="#" class="show-option">Show Config</a>
				<pre class="options">
{
	format: 'dddd MMM Do, YYYY'  //more formats at http://momentjs.com/docs/#/displaying/format/
}				</pre>
			</div>

			<div class="demo">
				Use future date shortcuts: <input id="date-range101" size="60" value="">
				<a href="#" class="show-option">Show Config</a>
				<pre class="options">
{
	showShortcuts: true,
	shortcuts :
	{
		'next-days': [3,5,7],
		'next': ['week','month','year']
	}
}				</pre>
			</div>

			<div class="demo">
				Use past date shortcuts: <input id="date-range102" size="60" value="">
				<a href="#" class="show-option">Show Config</a>
				<pre class="options">
{
	showShortcuts: true,
	shortcuts :
	{
		'prev-days': [3,5,7],
		'prev': ['week','month','year'],
		'next-days':null,
		'next':null
	}
}				</pre>
			</div>

			<div class="demo">
				Use custom shortcuts: <input id="date-range100" size="60" value="">
				<a href="#" class="show-option">Show Config</a>
				<pre class="options">
{
	showShortcuts: true,
	shortcuts : null,
	startOfWeek: 'sunday',
	language:'en',
	customShortcuts:
	[
		//if return an array of two dates, it will select the date range between the two dates
		{
			name: 'this week',
			dates : function()
			{
				var start = moment().day(0).toDate();
				var end = moment().day(6).toDate();
				return [start,end];
			}
		},
		//if only return an array of one date, it will display the month which containing the date. and it will not select any date range
		{
			name: 'Oct 2014',
			dates : function()
			{
				//move calendars to show this date's month and next month
				var movetodate = moment('2014-10','YYYY-MM').toDate();
				return [movetodate];
			}
		}
	]
}				</pre>
			</div>

			<div class="demo">
				Use custom values: <input id="date-range105" size="60" value="">
				<a href="#" class="show-option">Show Config</a>
				<pre class="options">
{
	language:'en',
	customValueLabel: 'Dynamic Ranges',
	showCustomValues: true,
	customValues:
		//if return an array of two dates, it will select the date range between the two dates
		[
			{
				name: 'MTD',
				value: 'Month To Date'
			},
			{
				name: 'YTD',
				value: 'Year To Date'
			}
		]
}				</pre>
			</div>


			<div class="demo">
				Auto-close after selection: <input id="date-range103" size="60" value="">
				<a href="#" class="show-option">Show Config</a>
				<pre class="options">
{
	autoClose: true
}				</pre>
			</div>

			<div class="demo">
				In-line mode: <input id="date-range12" size="40" value="">
				<a href="#" class="show-option">Show Config</a>
				<pre class="options">
{
	inline:true,
	container: '#date-range12-container',
	alwaysOpen:true
}				</pre>
				<div id="date-range12-container" style="width:456px;"></div>
			</div>

			<div class="demo">
				Single Date mode: <input id="date-range13" size="40" value="2015-03-01">
				<a href="#" class="show-option">Show Config</a>
				<pre class="options">
{
	autoClose: true,
	singleDate : true,
	showShortcuts: false
}				</pre>
			</div>


			<div class="demo">
				Single Date mode with single month: <input id="date-range13-2" size="40" value="2015-03-01">
				<a href="#" class="show-option">Show Config</a>
				<pre class="options">
{
	autoClose: true,
	singleDate : true,
	showShortcuts: false,
	singleMonth: true
}				</pre>
			</div>


			<div class="demo">
				 Batch mode ( week ): <input id="date-range14" size="60" value="">
				 <a href="#" class="show-option">Show Config</a>
				<pre class="options">
{
	batchMode: 'week',
	showShortcuts: false
}				</pre>
			</div>

    <div class="demo">
				Batch mode ( week-range ): <input id="date-range14-2" size="60" value="">
				<a href="#" class="show-option">Show Config</a>
				<pre class="options">
{
	batchMode: 'week-range',
	showShortcuts: false
}				</pre>
    </div>


			<div class="demo">
				Disable some dates: <input id="date-range15" size="60" value="">
				<a href="#" class="show-option">Show Config</a>
				<pre class="options">
{
	showShortcuts: false,
	beforeShowDay: function(t)
	{
		var valid = !(t.getDay() == 0 || t.getDay() == 6);  //disable saturday and sunday
		var _class = '';
		var _tooltip = valid ? '' : 'weekends are disabled';
		return [valid,_class,_tooltip];
	}
}				</pre>
			</div>

			<div class="demo">
				Control by script:
				<button id="date-range16-open">Open</button>
				<button id="date-range16-close">Close</button>
				<button id="date-range16-set">Set Date Range</button>
				<button id="date-range16-set-silent">Set Date Range (no event / silent: true)</button>
				<button id="date-range16-clear">Clear Selection</button>
				<button id="date-range16-destroy">Destroy</button>
				<button id="date-range16-reset">Reset months</button>
				<br>
				<input id="date-range16" size="60" value="">

				<a href="#" class="show-option">Show Config</a>
				<pre class="options">
$('#date-range16').dateRangePicker(
{
	showShortcuts: false,
	format: 'YYYY-MM-DD'
}).bind('datepicker-change', function(evt, obj) {
	alert('date1: ' + obj.date1 + ' / date2: ' + obj.date2);
});

$('#date-range16-open').click(function(evt)
{
	evt.stopPropagation();
	$('#date-range16').data('dateRangePicker').open();
});

$('#date-range16-close').click(function(evt)
{
	evt.stopPropagation();
	$('#date-range16').data('dateRangePicker').close();
});

$('#date-range16-set').click(function(evt)
{
	evt.stopPropagation();
	$('#date-range16').data('dateRangePicker').setDateRange('2013-11-20','2014-08-25');
});

$('#date-range16-set-silent').click(function(evt)
{
	evt.stopPropagation();
	$('#date-range16').data('dateRangePicker').setDateRange('2014-11-03','2015-02-12', true);
});

$('#date-range16-clear').click(function(evt)
{
	evt.stopPropagation();
	$('#date-range16').data('dateRangePicker').clear();
});

$('#date-range16-destroy').click(function(evt)
{
	evt.stopPropagation();
	$('#date-range16').data('dateRangePicker');
});

$('#date-range16-reset').click(function(evt)
{
	evt.stopPropagation();
	$('#date-range16').data('dateRangePicker').resetMonthsView();
});
				</pre>
			</div>

			<div class="demo">
				Sticky months: <input id="date-range17" size="60" value="">
				<a href="#" class="show-option">Show Config</a>
				<pre class="options">
{
	stickyMonths: true,
	startDate: '2013-01-10',
	endDate: '2013-05-10'
}				</pre>
			</div>


			<div class="demo">
				Use custom top bar: <input id="date-range18" size="60" value="">
				<a href="#" class="show-option">Show Config</a>
				<pre class="options">
{
	customTopBar: 'Foo Bar'
}</pre>
			</div>

			<div class="demo">
				Different class names of first and second selected dates: <input id="date-range19" size="60" value="">
				<a href="#" class="show-option">Show Config</a>
				<pre class="options">
{
	extraClass: 'date-range-picker19'
}
.date-picker-wrapper.date-range-picker19 .day.first-date-selected { background-color: red !important; }
.date-picker-wrapper.date-range-picker19 .day.last-date-selected { background-color: orange !important; }</pre>
			</div>

			<div class="demo">
				Hide hovering tooltip: <input id="date-range20" size="60" value="">
				<a href="#" class="show-option">Show Config</a>
				<pre class="options">
{
	hoveringTooltip: false
}</pre>
			</div>

			<div class="demo">
				Customize hovering tooltip: <input id="date-range21" size="60" value="">
				<a href="#" class="show-option">Show Config</a>
				<pre class="options">
{
	hoveringTooltip: function(days)
	{
		var D = ['One','Two', 'Three','Four','Five'];
		return D[days] ? D[days] : days;
	}
}</pre>
			</div>

			<div class="demo">
				Extra content on calendar: <input id="date-range22" size="60" value="">
				<a href="#" class="show-option">Show Config</a>
				<pre class="options">
{
	showDateFilter: function(time, date)
	{
		return '&lt;div style="padding:0 5px;">\
					&lt;span style="font-weight:bold">'+date+'&lt;/span>\
					&lt;div style="opacity:0.3;">$'+Math.round(Math.random()*999)+'&lt;/div>\
				&lt;/div>';
	}
}</pre>
			</div>

			<div class="demo">
				Single Month Mode: <input id="date-range23" size="30" value="">
				<a href="#" class="show-option">Show Config</a>
				<pre class="options">
{
	singleMonth: true,
	showShortcuts: false,
	showTopbar: false
}</pre>
			</div>

			<div class="demo">
				Show Week Numbers: <input id="date-range24" size="30" value="">
				<a href="#" class="show-option">Show Config</a>
				<pre class="options">
{
	showWeekNumbers: true
}</pre>
			</div>

			<div class="demo">
				Show Week Numbers (start from monday): <input id="date-range24-2" size="30" value="">
				<a href="#" class="show-option">Show Config</a>
				<pre class="options">
{
	showWeekNumbers: true,
	startOfWeek: 'monday'
}</pre>
			</div>

			<div class="demo">
				Show Week Numbers ( support fiscal year, start from 2015-08-16): <input id="date-range24-3" size="30" value="">
				<a href="#" class="show-option">Show Config</a>
				<pre class="options">
{
	showWeekNumbers: true,
	getWeekNumber: function(day)
	{
		var fiscalYearStart = moment('2015-08-16','YYYY-MM-DD');
		var daysOffset = parseInt(fiscalYearStart.format('DDD'),10);
		return moment(day).add( -1*daysOffset, 'days').format('W');
	}
}</pre>
			</div>

			<div class="demo">
				Select forward: <input id="date-range25" size="30" value="">
				<a href="#" class="show-option">Show Config</a>
				<pre class="options">
{
	selectForward: true
}</pre>
			</div>

			<div class="demo">
				Select backward: <input id="date-range26" size="30" value="">
				<a href="#" class="show-option">Show Config</a>
				<pre class="options">
{
	selectBackward: true
}</pre>
			</div>

			<div class="demo">
				Typical usage, hotel booking: <input id="hotel-booking" size="60" value="">
				<a href="#" class="show-option">Show Config</a>
				<pre class="options">
{
	startDate: new Date(),
	selectForward: true,
	showDateFilter: function(time, date)
	{
		return '&lt;div style="padding:0 5px;">\
					&lt;span style="font-weight:bold">'+date+'&lt;/span>\
					&lt;div style="opacity:0.3;">$'+Math.round(Math.random()*999)+'&lt;/div>\
				&lt;/div>';
	},
	beforeShowDay: function(t)
	{
		var valid = !(t.getDay() == 0 || t.getDay() == 6);  //disable saturday and sunday
		var _class = '';
		var _tooltip = valid ? '' : 'sold out';
		return [valid,_class,_tooltip];
	}
}				</pre>
			</div>

			<div class="demo">
				Custome open/close animation: <input id="date-range50" size="30" value="">
				<a href="#" class="show-option">Show Config</a>
				<pre class="options">
{
	customOpenAnimation: function(cb)
	{
		$(this).fadeIn(300, cb);
	},
	customCloseAnimation: function(cb)
	{
		$(this).fadeOut(300, cb);
	}
}</pre>
			</div>


            <h2 id="configuration">Configuration</h2>
			<pre><b>Usage:</b> $('#dom-id').dateRangePicker(configObject);</pre>
			<p>
				The default configuration object is:<br>
				<pre>{
	autoClose: false,
	format: 'YYYY-MM-DD',
	separator: ' to ',
	language: 'auto',
	startOfWeek: 'sunday',// or monday
	getValue: function()
	{
		return $(this).val();
	},
	setValue: function(s)
	{
		if(!$(this).attr('readonly') && !$(this).is(':disabled') && s != $(this).val())
		{
			$(this).val(s);
		}
	},
	startDate: false,
	endDate: false,
	time: {
		enabled: false
	},
	minDays: 0,
	maxDays: 0,
	showShortcuts: false,
	shortcuts:
	{
		//'prev-days': [1,3,5,7],
		//'next-days': [3,5,7],
		//'prev' : ['week','month','year'],
		//'next' : ['week','month','year']
	},
	customShortcuts : [],
	inline:false,
	container:'body',
	alwaysOpen:false,
	singleDate:false,
	lookBehind: false,
	batchMode: false,
	duration: 200,
	stickyMonths: false,
	dayDivAttrs: [],
	dayTdAttrs: [],
	applyBtnClass: '',
	singleMonth: 'auto',
	hoveringTooltip: function(days, startTime, hoveringTime)
	{
		return days > 1 ? days + ' ' + lang('days') : '';
	},
	showTopbar: true,
	swapTime: false,
	selectForward: false,
	selectBackward: false,
	showWeekNumbers: false,
	getWeekNumber: function(date) //date will be the first day of a week
	{
		return moment(date).format('w');
	}
}</pre>
			</p>
			<h3>You can use the following keys in the configObject to overwrite the default configuration:</h3>

<pre>
<b>format (String)</b>
	<i>The date format string used for Moment.
	click <a href="http://momentjs.com/docs/#/displaying/format/" target=_blank>here</a> to see Moment documentation</i>

<b>separator (String)</b>
	<i>The separator string used between date strings</i>

<b>language (String)</b>
	<i>pre-defined languages are "en" and "cn", you can define your own
 	language then set this to the name of new language.
	You can also set this to "auto" to make it auto detect browser language.</i>

<b>startOfWeek (String)</b>
	<i>"sunday" or "monday"</i>

<b>getValue (Function)</b>
	<i>This function is called when get date range string from DOM
	When it is called, the context of this function is set to the datepicker DOM</i>

<b>setValue (Function)</b>
	<i>This function is called when set date range string to DOM</i>

<b>startDate (String or false)</b>
	<i>This string defines the earliest date which is allowed for the user, same format as `format`</i>

<b>endDate (String or false)</b>
	<i>This string defines the latest date which is allowed for the user, same format as `format`</i>

<b>minDays (Number)</b>
	<i>This number defines the minimum days of the selected range
	if this is 0, means do not limit minimum days</i>

<b>maxDays (Number)</b>
	<i>This number defines the maximum days of the selected range
	if this is 0, means do not limit maximum days</i>

<b>showShortcuts (Boolean)</b>
	<i>hide or show shortcuts area</i>

<b>shortcuts (Object)</b>
	<i>define the shortcuts buttons. there are some built in shortcuts, see source code</i>

<b>time (Object)</b>
	<i>If enabled adds time selection controls.</i>

<b>customShortcuts (Array)</b>
	<i>define custom shortcut buttons. see demo.js</i>

<b>inline (Boolean)</b>
	<i>whether to render the date range picker dom in inline mode instead of overlay mode,
	if set to true, please set `container` too</i>

<b>container (String, css selector || DOM Object)</b>
	<i>where should the date range picker dom should be renderred to</i>

<b>alwaysOpen (Boolean)</b>
	<i>if you use inline mode, you may want the date range picker widget to be renderred when the page loads
	set this to true will also hide the "close" button
	</i>

<b>singleDate (Boolean)</b>
	<i>choose a single date instead of a date range. If `singleMonth` option is set to true it will show
	only one month instead of two months.
	</i>

<b>batchMode (false / 'week' / 'month')</b>
	<i> auto batch select mode </i>
	<i> false (default), week, month, week-range, month-range</i>

<b>beforeShowDay (Function)</b>
	<i>A function that takes a date as a parameter and must return an array with:
	[0]: true/false indicating whether or not this date is selectable
	[1]: a CSS class name to add to the date's cell or "" for the default presentation
	[2]: an optional popup tooltip for this date
	The function is called for each day in the datepicker before it is displayed.</i>

<b>stickyMonths (Boolean)</b>
	<i>If true, there will only be one previous and one next button. Clicking them will change
	both the months. This setting will have no effect if singleDate option is set to true</i>

<b>singleMonth (Boolean || 'auto') Default value: 'auto'</b>
	<i>If true, it will show only one month instead of two months. You can select date range
	in the one month view. If this is set to 'auto', it will be changed to true if the screen width
	is lower than 480.</i>

<b>showDateFilter ( Function(Int time, Int date) )</b>
	<i>This is a callback function when creating each date element in the calendar. First paramter will
	be the timestamp of that day. Second parameter will be the date of that month.</i>

<b>customTopBar ( Function || String)</b>
	<i>If you set this parameter, it will use this value in the top bar.</i>

<b>extraClass (String)</b>
	<i>Set extra class name to the date range picker dom.</i>

<b>showTopbar (Boolean)</b>
	<i>If show the top bar.</i>

<b>swapTime (Boolean)</b>
	<i>If true and if time is enabled, on choosing first enddate and than startdate, endtime and starttime will be swapped.
        If this configkey is false, only date will be swapped, time will stay constant.
        If time is disabled, this config key is not used.</i>

<b>selectForward (Boolean) Default: false</b>
	<i>If this is true, you can only select second date after the first selected date.</i>

<b>selectBackward (Boolean) Default: false</b>
	<i>If this is true, you can only select second date before the first selected date.</i>

<b>showWeekNumbers (Boolean) Default: false</b>
	<i>If this is true, it will show week number of the year in the calendar.</i>

<b>getWeekNumber (Function( Date object ) )</b>
	<i>the function called to generate the week number. the first parameter will be the first day of a week</i>

</pre>

	<h2>Events</h2>
	<p>events will be triggerred on the date range picker DOM</p>
<pre>$('#dom-id')
.dateRangePicker()
.bind('datepicker-first-date-selected', function(event, obj)
{
	/* This event will be triggered when first date is selected */
	console.log(obj);
	// obj will be something like this:
	// {
	// 		date1: (Date object of the earlier date)
	// }
})
.bind('datepicker-change',function(event,obj)
{
	/* This event will be triggered when second date is selected */
	console.log(obj);
	// obj will be something like this:
	// {
	// 		date1: (Date object of the earlier date),
	// 		date2: (Date object of the later date),
	//	 	value: "2013-06-05 to 2013-06-07"
	// }
})
.bind('datepicker-apply',function(event,obj)
{
	/* This event will be triggered when user clicks on the apply button */
	console.log(obj);
})
.bind('datepicker-close',function()
{
	/* This event will be triggered before date range picker close animation */
	console.log('before close');
})
.bind('datepicker-closed',function()
{
	/* This event will be triggered after date range picker close animation */
	console.log('after close');
})
.bind('datepicker-open',function()
{
	/* This event will be triggered before date range picker open animation */
	console.log('before open');
})
.bind('datepicker-opened',function()
{
	/* This event will be triggered after date range picker open animation */
	console.log('after open');
})
</pre>

<br>

	<h2>APIs</h2>
	<p></p>
<pre>//after you called  $(dom).dateRangePicker();

$(dom).data('dateRangePicker')
    //set date range, two date strings should follow the `format` in config object,
    //set the third argument to be `true` if you don't want this method to trigger a `datepicker-change` event.
	.setDateRange('2013-11-20','2013-11-25');
	.clear();		// clear date range
	.close();		// close date range picker overlay
	.open();		// open date range picker overlay
	.resetMonthsView();	// reset to default months
	.destroy();		// destroy all date range picker related things
</pre>

	<h2>License</h2>
	<pre>
This date range picker plugin is under MIT LICENSE
	</pre>
</div>


	<script>
	var d = new Date();
	var dd;
	$(function(){
		if(d.getHours()<=12){
			dd = d;
		}else{
			d.setDate(d.getDate() + 1);
			dd=d;
		}
		var d1 = d.DateAdd('d',2);
		$("#date-range200").val(d.getFullYear() + "年" + (d.getMonth()+1) + "月" + d.getDate() + "日");
		$("#date-range201").val(d1.getFullYear() + "年" + (d1.getMonth()+1) + "月" + d1.getDate() + "日");
		$('#two-inputs').dateRangePicker(
		{
			separator : ' 到 ',
			getValue: function()
			{
				if ($('#date-range200').val() && $('#date-range201').val() )
					return $('#date-range200').val() + ' 到 ' + $('#date-range201').val();
				else
					return '';
			},
			setValue: function(s,s1,s2)
			{
				$('#date-range200').val(s1);
				$('#date-range201').val(s2);
			},
			maxDays:7,
			startDate:dd,
			endDate:new Date().setDate(new Date().getDate()+30),
		});
	});
	$(function()
	{
		$('a.show-option').click(function(evt)
		{
			evt.preventDefault();
			$(this).siblings('.options').slideToggle();
		});
	})
	
	
	Date.prototype.DateAdd = function(strInterval, Number) {   
    var dtTmp = this;  
    switch (strInterval) {   
        case 's' :return new Date(Date.parse(dtTmp) + (1000 * Number));  
        case 'n' :return new Date(Date.parse(dtTmp) + (60000 * Number));  
        case 'h' :return new Date(Date.parse(dtTmp) + (3600000 * Number));  
        case 'd' :return new Date(Date.parse(dtTmp) + (86400000 * Number));  
        case 'w' :return new Date(Date.parse(dtTmp) + ((86400000 * 7) * Number));  
	    case 'q' :return new Date(dtTmp.getFullYear(), (dtTmp.getMonth()) + 
	Number*3, dtTmp.getDate(), dtTmp.getHours(), dtTmp.getMinutes(), 
	dtTmp.getSeconds());  
	       
	 case 'm' :return new Date(dtTmp.getFullYear(), (dtTmp.getMonth()) + 
	Number, dtTmp.getDate(), dtTmp.getHours(), dtTmp.getMinutes(), 
	dtTmp.getSeconds());  
	       
	 case 'y' :return new Date((dtTmp.getFullYear() + Number), 
	dtTmp.getMonth(), dtTmp.getDate(), dtTmp.getHours(), dtTmp.getMinutes(),
	 dtTmp.getSeconds());  
	    }  
	}  
	
	</script>
     </div>
	</body>
</html>
