<%-- 
    Document   : seat-select
    Created on : Oct 10, 2023, 12:32:59 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Booking page</title>
        <link rel="stylesheet" href="css/member.css"/>

        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
            integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
            />
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link href="Cart.css">
        <!-- Latest compiled and minified CSS -->

        <script
        src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
              crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
              integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
              crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>


        <link href='https://fonts.googleapis.com/css?family=Lato:400,700'
              rel='stylesheet' type='text/css'>
        <link rel="stylesheet" type="text/css"
              href="jQuery-Seat-Charts/jquery.seat-charts.css">
        <!-- <link rel="stylesheet" type="text/css" href="jQuery-Seat-Charts/style.css"> -->
        <script src="jQuery-Seat-Charts/jquery-1.11.0.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <title>Document</title>
        <link rel="stylesheet" href="css/Cart.css">
    </head>
    <body>
        <%@ include file="/include/header.jsp" %>


        <div class="">
            <input name="listSeat" id="listsbooking" hidden="hidden" />
            <div class="row">
                <div class="col-sm-8 col-xs-12 col-ms-12">
                    <div id="seat-map"></div>
                </div>
                <div class="col-sm-4 col-xs-12 col-ms-12">
                    <div class="booking-details">

                        <div id="legend"></div>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script src="jQuery-Seat-Charts/jquery-1.11.0.min.js"></script>
        <script src="jQuery-Seat-Charts/jquery.seat-charts.js"></script>

        <script>
            var firstSeatLabel = 1;
            $(document).ready(function () {
                var cartAdd = new Map();
                var $cart = $('#selected-seats'),
                        $counter = $('#counter'),
                        $total = $('#total'),
                        sc = $('#seat-map').seatCharts({
                    map: [
                        'ee_ee',
                        'ee_ee',
                        'ee_ee',
                        'ee_ee',
                        'ee_ee',
                        'ee_ee',
                        'ee_ee',
                        'ee_ee',
                        'eeeee',
                    ],
                    seats: {
                        f: {
                            price: 100,
                            classes: 'first-class', //your custom CSS class
                            category: 'Number'
                        },
                        e: {
                            price: ${bus.getPrice()},
                            classes: 'economy-class', //your custom CSS class
                            category: 'Number'
                        }
                    },
                    naming: {
                        top: false,
                        getLabel: function (character, row, column) {
                            return firstSeatLabel++;
                        },
                    },
                    legend: {
                        node: $('#legend'),
                        items: [

                            ['e', 'available', 'Ghế trống'],
                            ['f', 'unavailable', 'Ghế đặt']
                        ]
                    },
                    click: function () {
                        var key = '';
                        var value = '';
                        if (this.status() == 'available') {
                            //let's create a new <li> which we'll add to the cart items
                            $('<li>' + this.data().category + ' Seat # ' + this.settings.label + ': <b>$' + this.data().price + '</b> <a href="#" class="cancel-cart-item">[cancel]</a></li>')
                                    .attr('id', 'cart-item-' + this.settings.id)
                                    .data('seatId', this.settings.id)
                                    .appendTo($cart);

                            /*
                             * Lets update the counter and total
                             *
                             * .find function will not find the current seat, because it will change its stauts only after return
                             * 'selected'. This is why we have to add 1 to the length and the current seat price to the total.
                             */
                            $counter.text(sc.find('selected').length + 1);
                            $total.text(recalculateTotal(sc) + this.data().price);
                            cartAdd.set(this.settings.id, this.data().price);

                            for (var i of cartAdd.keys()) {
                                key += ' ' + i;
                            }
                            console.log(cartAdd);
                            document.getElementById("listsbooking").value = key;
                            return 'selected';
                        } else if (this.status() == 'selected') {
                            //update the counter
                            $counter.text(sc.find('selected').length - 1);
                            //and total
                            $total.text(recalculateTotal(sc) - this.data().price);

                            //remove the item from our cart
                            $('#cart-item-' + this.settings.id).remove();
                            //seat has been vacated
                            cartAdd.delete(this.settings.id);

                            for (var i of cartAdd.keys()) {
                                key += ' ' + i;
                            }
                            console.log(cartAdd);
                            document.getElementById("listsbooking").value = key;
                            return 'available';
                        } else if (this.status() == 'unavailable') {
                            //seat has been already booked
                            return 'unavailable';
                        } else {
                            return this.style();
                        }
                    }
                });

                //this will handle "[cancel]" link clicks
                $('#selected-seats').on('click', '.cancel-cart-item', function () {
                    //let's just trigger Click event on the appropriate seat, so we don't have to repeat the logic here
                    sc.get($(this).parents('li:first').data('seatId')).click();
                });

                //let's pretend some seats have already been booked
                var booked = new Array();
            <c:forEach items="${ListSeat}" var="a" >
                booked.push("${a.getSeat_number()}");//// data get id seat
            </c:forEach>
                sc.get(booked).status('unavailable');
            });
            function recalculateTotal(sc) {
                var total = 0;

                //basically find every selected seat and sum its price
                sc.find('selected').each(function () {
                    total += this.data().price;
                });

                return total;
            }

        </script>

</html>
