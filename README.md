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

## Performance
No data yet
