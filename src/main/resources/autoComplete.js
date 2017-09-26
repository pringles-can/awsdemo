$(document).ready(function() {
    $(function() {
        $("#myNavbar.form-control").autocomplete({
            source: function(request, response) {
                $.ajax({
                    url: "/person/getPeople",
                    type: "POST",
                    data: { term: request.term },

                    dataType: "json",

                    success: function(data) {
                        response($.map(data, function(v,i){
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