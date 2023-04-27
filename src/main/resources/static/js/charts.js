let chart01 = {
    cc:null,
    init: (cc) =>{
        chart01.cc = cc;
        chart01.getdata(cc);
    },
    getdata: (cc) => {
        $.ajax({
            url:'/chartImpl01',
            success: (result) => {
                // console.log(result);
                chart01.display(result);
            }
        });
    },
    display: (result) => {
        // console.log(result)
        Highcharts.chart(chart01.cc, {
            chart: {
                type: 'area'
            },
            title: {
                text: 'Greenhouse gases from Norwegian economic activity',
                align: 'left'
            },
            subtitle: {
            },
            yAxis: {
                title: {
                    useHTML: true,
                    text: 'Million tonnes CO<sub>2</sub>-equivalents'
                }
            },
            tooltip: {
                shared: true,
                headerFormat: '<span style="font-size:12px"><b>{point.key}</b></span><br>'
            },
            plotOptions: {
                series: {
                    pointStart: 2012
                },
                area: {
                    stacking: 'normal',
                    lineColor: '#666666',
                    lineWidth: 1,
                    marker: {
                        lineWidth: 1,
                        lineColor: '#666666'
                    }
                }
            },
            //{ {name, data[]}, {}...}
            series: result
        });

    }
}

let chart02 = {
    cc: null,
    init : function(cc){
        this.cc = cc;
        this.getdata(cc);
    },
    getdata: function(cc){
        $.ajax({
            url:'/chartImpl02',
            success:(result) => {
                this.display(result);
            }
        });
    },
    display: function(result){
        // Age categories
        var categories = [
            '0-4', '5-9', '10-14', '15-19', '20-24', '25-29', '30-34', '35-40', '40-45',
            '45-49', '50-54', '55-59', '60-64', '65-69', '70-74', '75-79', '80+'
        ];

        Highcharts.chart(this.cc, {
            chart: {
                type: 'bar'
            },
            title: {
                text: 'Population pyramid for Somalia, 2021',
                align: 'left'
            },
            subtitle: {
                text: 'Source: <a ' +
                    'href="https://countryeconomy.com/demography/population-structure/somalia"' +
                    'target="_blank">countryeconomy.com</a>',
                align: 'left'
            },
            accessibility: {
                point: {
                    valueDescriptionFormat: '{index}. Age {xDescription}, {value}%.'
                }
            },
            xAxis: [{
                categories: categories,
                reversed: false,
                labels: {
                    step: 1
                },
                accessibility: {
                    description: 'Age (male)'
                }
            }, { // mirror axis on right side
                opposite: true,
                reversed: false,
                categories: categories,
                linkedTo: 0,
                labels: {
                    step: 1
                },
                accessibility: {
                    description: 'Age (female)'
                }
            }],
            yAxis: {
                title: {
                    text: null
                },
                labels: {
                    formatter: function () {
                        return Math.abs(this.value) + '%';
                    }
                },
                accessibility: {
                    description: 'Percentage population',
                    rangeDescription: 'Range: 0 to 5%'
                }
            },

            plotOptions: {
                series: {
                    stacking: 'normal',
                    borderRadius: '50%'
                }
            },

            tooltip: {
                formatter: function () {
                    return '<b>' + this.series.name + ', age ' + this.point.category + '</b><br/>' +
                        'Population: ' + Highcharts.numberFormat(Math.abs(this.point.y), 1) + '%';
                }
            },

            series: [{
                name: 'Male',
                data: result.male
            }, {
                name: 'Female',
                data: result.female
            }]
        });
    }
}

let chart03 = {
    cc : null,
    init(cc){
        this.cc = cc;
        this.getdata(cc);
    },
    getdata(cc){
        $.ajax({
            url:'/chartImpl03',
            success:(result) => {
                this.display(result);
            }
        });
    },
    display(result){
        Highcharts.chart(this.cc, {
            chart: {
                type: 'bar'
            },
            title: {
                text: 'UEFA CL top scorers by season'
            },
            xAxis: {
                categories: ['2020/21', '2019/20', '2018/19', '2017/18', '2016/17']
            },
            yAxis: {
                min: 0,
                title: {
                    text: 'Goals'
                }
            },
            legend: {
                reversed: true
            },
            plotOptions: {
                series: {
                    stacking: 'normal',
                    dataLabels: {
                        enabled: true
                    }
                }
            },
            series: [{
                name: 'Cristiano Ronaldo',
                data: result.ronaldo
            }, {
                name: 'Lionel Messi',
                data: result.messi
            }, {
                name: 'Robert Lewandowski',
                data: result.lewan
            }]
        });
    }
}