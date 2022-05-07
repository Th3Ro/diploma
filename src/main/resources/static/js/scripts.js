window.addEventListener('DOMContentLoaded', event => {

    // Navbar shrink function
    var navbarShrink = function () {
        const navbarCollapsible = document.body.querySelector('#mainNav');
        if (!navbarCollapsible) {
            return;
        }
        if (window.scrollY === 0) {
            navbarCollapsible.classList.remove('navbar-shrink')
        } else {
            navbarCollapsible.classList.add('navbar-shrink')
        }

    };

    // Shrink the navbar 
    navbarShrink();

    // Shrink the navbar when page is scrolled
    document.addEventListener('scroll', navbarShrink);

    // Activate Bootstrap scrollspy on the main nav element
    const mainNav = document.body.querySelector('#mainNav');
    if (mainNav) {
        new bootstrap.ScrollSpy(document.body, {
            target: '#mainNav',
            offset: 74,
        });
    };

    // Collapse responsive navbar when toggler is visible
    const navbarToggler = document.body.querySelector('.navbar-toggler');
    const responsiveNavItems = [].slice.call(
        document.querySelectorAll('#navbarResponsive .nav-link')
    );
    responsiveNavItems.map(function (responsiveNavItem) {
        responsiveNavItem.addEventListener('click', () => {
            if (window.getComputedStyle(navbarToggler).display !== 'none') {
                navbarToggler.click();
            }
        });
    });

});

function goTop() {
    const el = document.getElementById('up');
    el.scrollIntoView();
}

function goCalculate() {
    const el = document.getElementById('calculation');
    el.scrollIntoView();
}

function goContacts() {
    const el = document.getElementById('contacts');
    el.scrollIntoView();
}

function getModels(brand) {
    $.ajax({
        url: '/models',
        type: 'POST',
        data: brand,
        dataType: 'text',
        contentType: false,
        success: function(response) {
            responseData = JSON.parse(response);
            $('#models').removeClass('hidden');
            $('#modelsList').empty();
            $('#details').addClass('hidden');
            $('#detailsList').empty();
            for (let i = 0; i <= responseData.length-1; i++) {
                let model = responseData[i];
                $('#modelsList').append(
                    '<div class="col-md-4 mt-5 mb-md-0 col-cursor">' +
                        '<div class="card py-4 h-100" id="' + model.id + '" onClick="getDetails(this.id)">' +
                            '<div class="card-body d-flex align-items-center">' +
                                '<h4 class="text-uppercase m-auto">' + model.name + '</h4>' +
                            '</div>' +
                        '</div>' +
                    '</div>'
                );
            }
            const el = document.getElementById('models');
            el.scrollIntoView();
        }
    });
}

function getDetails(modelId) {
    console.log("It's just work");
    console.log(modelId);
    $.ajax({
        url: '/details',
        type: 'POST',
        data: modelId,
        dataType: 'text',
        contentType: false,
        success: function(response) {
            responseData = JSON.parse(response);
            console.log(responseData);
            if (responseData !== null) {
                $('#details').removeClass('hidden');
                $('#detailsList').empty();
                for (let i = 0; i <= responseData.length-1; i++) {
                    let detail = responseData[i];
                    console.log(detail.name);
                    $('#detailsList').append(
                        '<div class="col-md-4 mt-5 mb-md-0 col-cursor">' +
                            '<div class="card py-4 h-100" id="' + detail.id + '" onClick="">' +
                                '<div class="card-body text-center">' +
                                    '<h4 class="text-uppercase m-0">' + detail.name + '</h4>' +
                                    '<hr class="my-4 mx-auto"/>' +
                                    '<div class="small text-black-50">Повреждение:' +
                                    '</div>' +
                                '</div>' +
                            '</div>' +
                        '</div>'
                    );
                }
                const el = document.getElementById('details');
                el.scrollIntoView();
            }
        }
    });
}