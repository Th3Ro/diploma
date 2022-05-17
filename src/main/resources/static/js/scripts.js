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

window.onload = getCities;

function getCities() {
    $.ajax({
        url: '/cities',
        type: 'GET',
        success: function(response) {
            for (let i = 0; i <= response.length-1; i++) {
                let city = response[i];
                $('#citySelector').append(
                    '<option value="' + city.id + '">' + city.name + '</option>'
                );
            }
        }
    });
}

function setCity(cityId) {
    if ($('#brands').attr('class').split(/\s+/).includes('hidden')) getBrands();
    else if (cityId == '') $('#brands').addClass('hidden');

}

function getBrands() {
    $.ajax({
        url: '/brands',
        type: 'GET',
        success: function(response) {
            $('#brands').removeClass('hidden');
            $('#brandsList').empty();
            for (let i = 0; i <= response.length-1; i++) {
                let brand = response[i];
                $('#brandsList').append(
                    '<div class="col mb-5 col-animate pointer-cursor">' +
                        '<div class="card py-4 h-100" id="' + brand.name + '" onClick="getModels(this.id)">' +
                            '<div class="card-body text-center d-flex justify-content-center">' +
                                '<img class="brand-image" src="assets/images/brands/' + brand.name + '.jpg">' +
                            '</div>' +
                        '</div>' +
                    '</div>'
                );
            }
        }
    });
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
                    '<div class="col-md-4 mt-5 mb-md-0 col-animate pointer-cursor">' +
                        '<div class="card py-4 h-100" id="' + model.id + 'model" onClick="getDetailsAndDefects(this.id)">' +
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

function getDetailsAndDefects(modelId) {
    modelId = modelId.replace('model', '');
    $.ajax({
        url: '/defects',
        type: 'GET',
        success: function(response) {
            defects = response;
            $('#defectsExamples').empty();
            $('#defectsExamples').append('<div class="row gx-4 gx-lg-5 d-flex justify-content-center"></div>>');
            for(let i = 0; i < defects.length; i++) {
                $('#defectsExamples').children().append(
                    '<div class="col-md-4 mt-5 mb-md-0 col-animate">' +
                        '<div class="card py-4 h-100">' +
                            '<div class="card-body text-center">' +
                                '<h5 class="text-uppercase m-0">' + defects[i].name + '</h5>' +
                                '<hr class="my-4 mx-auto"/>' +
                                '<div class="small text-black-50">' +
                                    '<img class="brand-image" src="assets/images/defects/' + defects[i].name + '.jpg">' +
                                '</div>' +
                            '</div>' +
                        '</div>' +
                    '</div>'
                )
            }
            $.ajax({
                url: '/details',
                type: 'POST',
                data: modelId,
                dataType: 'text',
                contentType: false,
                success: function(response) {
                    responseData = JSON.parse(response);
                    if (responseData !== null) {
                        $('#details').removeClass('hidden');
                        $('#detailsList').empty();
                        for (let i = 0; i <= responseData.length-1; i++) {
                            let detail = responseData[i];
                            $('#detailsList').append(
                                '<div class="col-md-4 mt-5 mb-md-0 col-animate">' +
                                    '<div class="card py-3 h-100" id="' + detail.id + 'detail" onClick="">' +
                                        '<div class="card-body text-center">' +
                                            '<h4 class="text-uppercase m-0">' + detail.name + '</h4>' +
                                            '<hr class="my-4 mx-auto"/>' +
                                            '<div class="small text-black-50">Повреждение:' +
                                            '</div>' +
                                        '</div>' +
                                    '</div>' +
                                '</div>'
                            );
                            let id = '#' + detail.id + 'detail';
                            let newForm = '<form action="" class="d-flex flex-column">';
                            for (let i = 0; i <= defects.length-1; i++) {
                                newForm +=
                                    '<label class="d-flex align-items-start text-start mt-1 pointer-cursor" for="' + defects[i].name + detail.id + '">' +
                                        '<input class="align-self-center me-1" onchange="onDefectSelected(' + detail.id + ', this.value)" id="' + defects[i].name + detail.id + '" name="' + detail.name + '" type="radio" value="' + defects[i].name + '">' +
                                        defects[i].name +
                                    '</label>';
                            }
                            newForm +=
                                    '<label class="d-flex align-items-start text-start mt-1 pointer-cursor" for="nothing' + detail.id + '">' +
                                        '<input class="align-self-center me-1" onchange="onDefectSelected(' + detail.id + ', this.value)" id="nothing' + detail.id + '" name="' + detail.name + '" type="radio" value="Ничего (не обязательно)">' +
                                        'Ничего (не обязательно)' +
                                    '</label>' +
                                '</form>';
                            $(id).children().append(newForm);
                        }
                    }
                    const el = document.getElementById('detailsList');
                    el.scrollIntoView();
                }
            });
        }
    });
}

function onDefectSelected(defectId, value) {
    //todo add functional
    console.log("it's worked " + defectId + ' value - ' + value);
}
