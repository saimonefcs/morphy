# Morphy
##### Open-source fluent image manipulation library
Meant to be easy to use with a fluent api.<br>
The actual manipulation is done at the end, in the build command for performance reasons. 

##Features
 - Rotate
    - Clockwise
    - Anti-clockwise
    - Upside-down
 - Flip
    - On vertical axis
    - On horizontal axis
 - Blur
    - Light
    - Medium
    - Heavy
 
## Open source and PRs
Feel free to add and/or request new features.
Unit tests are mandatory

## Usages
```
Morphy.fromFile(file).flip(Flip.VERTICAL_AXIS).buildImage();
Morphy.fromFile(file).blur(Blur.LIGHT).buildImage();
Morphy.fromImage(bufferedImage).rotate(Rotate.UPSIDE_DOWN).buildImage();
Morphy.compareImages(firstImage, secondImage)
```
## Unit tests
Done by comparing image expectations.

## Performances
All the times are taken on an idle quad-core 1.10GHz laptop. The operations are pixel-number dependent, the more there are the longer it will take with a linear curve O(n).

###Blur
Taking in consideration an image 1280x720px and 100 iterations the average results are:
- LIGHT: 0.416s
- MEDIUM: 7.764s
- HEAVY: 26.219s

Taking in consideration an image 1920x1080px and 100 iterations the average results are:
- LIGHT: 0.850s
- MEDIUM: 11.641s
- HEAVY: 45.583s

