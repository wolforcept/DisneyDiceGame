// String name, h|s|v type, String keywords, blue|red|gray|yellow|green|purple color, bigstring content, string power, string ability, boolean isTriggered

int width = 780
int height = 1088

abrev 'd1', 'dice_1.png'
abrev 'd2', 'dice_2.png'
abrev 'd3', 'dice_3.png'
abrev 'd4', 'dice_4.png'
abrev 'd5', 'dice_5.png'
abrev 'd6', 'dice_6.png'
abrev 'red', 'symbol_red.png'
abrev 'green', 'symbol_green.png'
abrev 'blue', 'symbol_blue.png'
abrev 'yellow', 'symbol_yellow.png'
abrev 'purple', 'symbol_purple.png'
abrev 'gray', 'symbol_gray.png'
abrev 'arrow', 'arrow_black.png'

image "images/${color}/${name.toLowerCase().replace(' ', '_')}.png", 0, 0, width, height
image "back_${color}.png", 0, 0, width, height
image "frame_${type}.png", 0, 0, width, height

// power
if (power != 'none') {
    if (power == '') power = color
    String[] powers = power.split(',')
    for (int i = 0; i < powers.length; i++)
    image powers[i], width - 135 - 90 * i, 580
}

// name
font 'Goldplay SemiBold', 60, 'bold'
text name, 50, 654

// keywords
font 'Goldplay SemiBold', 34, 'italic,center'
color '#FFFFFF'
text keywords, 0, 717, width

// content
// textImagesDefaults 0, 0, 0.6
// text content, 0, height - 70, width

String[] contentParts = content.split(' ')
int totalWidth = 0
for (part in contentParts) {
    if (part == '>') {
        totalWidth += 110
    }
    else {
        totalWidth += 100
    }
}
int contentX = width * 0.5 - totalWidth * 0.5
int contentY = height - 150
if (!content.equals("")) {
    for (int i = 0; i < contentParts.length; i++) {
        String part = contentParts[i]
        if (part == '>') {
            image 'arrow', contentX - 4, contentY + 21, 105, 42
            contentX += 110
        }
    else {
            image part, contentX, contentY, 82, 82
            contentX += 100
    }
    }
}

font 'Goldplay SemiBold', 35, 'center'
if (isTriggered == 'true') {
    color '#FFFFFF'
    image "box_${color}.png", 0, -140, width, height
    if (ability != '') {
        text ability, 90, height - 282, width - 180
    }
}else {
    color '#000000'
    if (ability != '') {
        text ability, 50, height - 300, width - 100
    }
}
