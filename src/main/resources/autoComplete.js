$(document).ready(function() {
    $(function() {
        $("#searcher").autocomplete({
            source: function(request, response) {
                $.ajax({
                    url: "/person/getPeople",
                    type: "POST",
                    data: { term: request.term },

                    dataType: "json",

                    success: function(data) {
                        response($.map(data, function(v,i){
                            console.log("v.empName = " + v.empName)
                            return {
                                label: v.empName,
                                value: v.empName
                            };
                        }));
                    }
                });
            }
        });
    });
});