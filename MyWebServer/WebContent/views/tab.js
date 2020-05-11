function swap(type, ind) {
	var id_type = "id_type=" + type;

	var burgers = document.getElementById("burgers");
	var drinks = document.getElementById("drinks");
	var contacts = document.getElementById("contacts");

	var li = document.getElementsByClassName("nav-button")

	for (var i = 0; i < li.length; i++) {
		if (i == ind) {
			li[i].style.borderBottom = "1.5px";
			li[i].style.color = "rgba(228, 0, 43, 1)";
			li[i].style.borderBottomStyle = "solid";
			li[i].style.fontWeight = "bold";
		} else {
			li[i].style.border = "0";
			li[i].style.color = "black";
		}
	}
	if (ind < 2) {
		$.ajax({
			type : "POST",
			url : "GetFoods",
			data : id_type,
			dataType : 'json',
			success : function(data) {
				var foods = data.allFoods;
				var div = $("#foodsTable"); // какая разница между getElementById??????
				var result;
				var size;
				var table = document.getElementById("foodsTable");
				div.empty();
				switch (type) {
				case 1:
					size = "width='200' height='150'";
					table.style.marginLeft = "80px";
					table.style.borderSpacing = "10px";
					break;
				case 2:
					size = "width='100' height='150'";
					table.style.marginLeft = "70px";
					table.style.borderSpacing = "10px";
					break;
				}

				length = foods.length;
				var i = 0.0;
				while (i < length) {
					result += "<tr>";
					while (i < length) {
						result += "<td class=foodText' >"
								+ "<img " + size + " src='img/"
								+ foods[i].image + "'>" + "<br>"
								+ foods[i].title + "<br>" + foods[i].price
								+ "<br><br>"
								+ "<a id='addtobasket' onclick='addToBasket("
								+ foods[i].id_good + ")'>"
								+ "Добавить в корзину" + "</a>" + "</td>";
						i++;
						if (i == 4) {
							break;
						}
					}
					result += "</tr>";
				}
				div.append(result);
			}
		});
	}
}

function addToBasket(id) {
	var id_good = "id_good=" + id;
	$.ajax({
		type : "GET",
		url : "AddToBasket",
		data: id_good,
		success : function(answer) {
			alert(answer);
		}
	});
}
