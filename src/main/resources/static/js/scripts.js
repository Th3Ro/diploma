window.addEventListener('DOMContentLoaded', event => {

    // Navbar shrink function
    let navbarShrink = function () {
        const navbarCollapsible = $('#mainNav');
        if (!navbarCollapsible) {
            return;
        }
        if (window.scrollY === 0) {
            navbarCollapsible.removeClass('navbar-shrink');
        } else {
            navbarCollapsible.addClass('navbar-shrink');
        }

    };

    // Shrink the navbar 
    navbarShrink();

    // Shrink the navbar when page is scrolled
    document.addEventListener('scroll', navbarShrink);

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
    getBrands();
}

function goContacts() {
    const el = document.getElementById('contacts');
    el.scrollIntoView();
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
            let responseData = JSON.parse(response);
            $('#models').removeClass('hidden');
            $('#modelsList').empty();
            $('#details').addClass('hidden');
            $('#detailsList').empty();
            for (let i = 0; i <= responseData.length-1; i++) {
                let model = responseData[i];
                $('#modelsList').append(
                    '<div class="col-md-4 mt-5 mb-md-0 col-animate pointer-cursor">' +
                        '<div class="card py-4 h-100" id="' + model.id + 'model" onClick="getRegulations(this.id)">' +
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

function getRegulations(modelId) {
    modelId = modelId.replace('model', '');
    $.ajax({
        url: '/model',
        type: 'POST',
        data: modelId,
        dataType: 'text',
        contentType: false
    });

    $.ajax({
        url: '/regulations',
        type: 'GET',
        success: function(response) {
            let regulations = response;
            if (regulations !== null) {
                $('#regulations').removeClass('hidden');
                $('#regulationsTable').empty();
                for (let i = 0; i <= regulations.length-1; i++) {
                    let row = regulations[i];
                    if (row.needBodyWork) {
                        let newDropbox = '<select class="form-select text-light bg-transparent" id="bodyWorks" onchange="onBodyWorkSelected('+ row.id +', this.value)">' +
                                            '<option selected value="Нет повреждений" class="bg-dark">Нет повреждений</option>';
                        for (let i = 0; i <= row.bodyWorks.length-1; i++) {
                            newDropbox += '<option value="' + row.bodyWorks[i].name + '" class="bg-dark">'+ row.bodyWorks[i].name +'</option>';
                        }
                        newDropbox += '</select>';
                        $('#regulationsTable').append(
                            '<tr class="text-start">' +
                                '<td>'+ row.criterionName + '</td>' +
                                '<td width="25%">' +
                                    newDropbox +
                                '</td>' +
                            '</tr>'
                        );
                    } else {
                        $('#regulationsTable').append(
                            '<tr class="text-start">' +
                                '<td>'+ row.criterionName + '</td> ' +
                                '<td width="25%">' +
                                    '<div class="input-group-text">' +
                                        '<input class="form-check-input mt-0 mx-auto" type="checkbox" value="" id="'+ row.criterionName +'" onchange="onRegulationsChecked('+ row.id +', this.checked)">' +
                                    '</div>' +
                                '</td>' +
                            '</tr>'
                        );
                    }
                }
            }
            const el = document.getElementById('regulations');
            el.scrollIntoView();
        }
    });
}

function onRegulationsChecked(regulationsId, isChecked) {
    $.ajax({
        url: '/regulations',
        type: 'POST',
        data: JSON.stringify({"regulationsId":regulationsId, "isChecked":isChecked}),
        contentType: 'application/json'
    });
}

function onBodyWorkSelected(regulationsId, bodyWorkName) {
    $.ajax({
        url: '/bodyWork',
        type: 'POST',
        data: JSON.stringify({"regulationsId":regulationsId, "bodyWorkName":bodyWorkName}),
        contentType: 'application/json'
    });
}
