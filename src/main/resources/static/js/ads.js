(function($) {
    var request = $.ajax({'url': '/ads.json'});
    request.done(function (ads) {
        var html = '';
        ads.forEach(function(ad) {
            html += '<div>';
            html += '<h1>' + ad.title + '</h1>';
            html += '<p>' + ad.description + '</p>';
            html += '<p>Published by ' + ad.owner.username + '</p>';
            html += '</div>';
        });
        $('#ads').html(html);
    });
})(jQuery);