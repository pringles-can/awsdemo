<table>

    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#aabcfe;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#aabcfe;color:#669;background-color:#e8edff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#aabcfe;color:#039;background-color:#b9c9fe;}
        .tg .tg-mbw0{font-size:14px;font-family:"Trebuchet MS", Helvetica, sans-serif !important;;background-color:#cbf6c8;color:#a1e09d;vertical-align:top}
        .tg .tg-2l3u{background-color:#cbf6c8;color:#a1e09d;vertical-align:top}
        .tg .tg-mkpy{font-size:16px;font-family:"Trebuchet MS", Helvetica, sans-serif !important;;background-color:#cbf6c8;color:#32cb00;vertical-align:top}
    </style>

    <form method = "post" action = "/CRUD/search" >
        <table class="tg">
            <tr>
                <th class="tg-mkpy">Search by ID:</th>
                <th class="tg-mbw0"><input type="text" name = "id" id="id23" /></th>
                <th class="tg-mbw0"><input type="submit" id="id25" /></th>
            </tr>

            <tr>
                <td class="tg-d7nh">${kitty.id}</td>
                <td class="tg-d7nh">${kitty.catName}</td>
                <td class="tg-d7nh">${kitty.fluffyRating}</td>
                <td class="tg-jnuu"><img src="/CRUD/imageDisplay?id=${kitty.id}"/></td>
            </tr>

        </table>
    </form>
    <table>

        <style type="text/css">
            .tg  {border-collapse:collapse;border-spacing:0;border-color:#aabcfe;}
            .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#aabcfe;color:#669;background-color:#e8edff;}
            .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#aabcfe;color:#039;background-color:#b9c9fe;}
            .tg .tg-mbw0{font-size:14px;font-family:"Trebuchet MS", Helvetica, sans-serif !important;;background-color:#cbf6c8;color:#a1e09d;vertical-align:top}
            .tg .tg-2l3u{background-color:#cbf6c8;color:#a1e09d;vertical-align:top}
            .tg .tg-mkpy{font-size:16px;font-family:"Trebuchet MS", Helvetica, sans-serif !important;;background-color:#cbf6c8;color:#32cb00;vertical-align:top}
        </style>

        <form method = "post" action = "/CRUD/search" >
            <table class="tg">
                <tr>
                    <th class="tg-mkpy">Search by ID:</th>
                    <th class="tg-mbw0"><input type="text" name = "id" id="id23" /></th>
                    <th class="tg-mbw0"><input type="submit" id="id25" /></th>
                </tr>

                <tr>
                    <td class="tg-d7nh">${kitty.id}</td>
                    <td class="tg-d7nh">${kitty.catName}</td>
                    <td class="tg-d7nh">${kitty.fluffyRating}</td>
                    <td class="tg-jnuu"><img src="/CRUD/imageDisplay?id=${kitty.id}"/></td>
                </tr>

            </table>
        </form>

    </table>
    Add Comment

</table>