let hl8State = ["heatload8Box", "checkplaceBox", "newplaceBox", "distanceBox", "newdistanceBox", "acousticBox", "newplaceVABox", "radtempBox", "reconstradtempBox", "surfencradtempBox"];
// let hl910State = new State("heatload910", ["heatload910Box", "checkplaceBox", "newplaceBox hidden", "distanceBox hidden", ]);
// let hl11State = new State("heatload11", ["heatload11Box"]);
// add all states here
$("#heatLoad").change(function(){
    $(".heatload8Box").removeClass("hidden");
});

$("#heatload8").change(function(){
    $(".checkplaceBox").removeClass("hidden");
});
$("#checkplace").change(function(){
    $(".newplaceBox").removeClass("hidden");
});
$("#newplace").change(function(){
    $(".distanceBox").removeClass("hidden");
});
$("#distance").change(function(){
    $(".newdistanceBox").removeClass("hidden");
});
$("#newdistance").change(function(){
    $(".acousticBox").removeClass("hidden");
});
$("#acoustic").change(function(){
    $(".newplaceVABox").removeClass("hidden");
});
$("#newplaceVA").change(function(){
    $(".radtempBox").removeClass("hidden");
});
$("#radtemp").change(function(){
    $(".reconstradtempBox").removeClass("hidden");
});
$("#reconstradtemp").change(function(){
    $(".surfencradtempBox").removeClass("hidden");
});