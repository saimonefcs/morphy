# Morphy
##### Open-source fluent image manipulation library

##Features
 - Rotate
 - Flip
 - Blur
 
## Open source and PRs
Feel free to add and/or request new features.
Tests are mandatory

## Usages
```
Morphy.fromFile(file).flip(Flip.VERTICAL_AXIS).buildImage();
Morphy.fromFile(file).blur(Blur.LIGHT).buildImage();
Morphy.fromImage(bufferedImage).rotate(Rotate.UPSIDE_DOWN).buildImage();
Morphy.compareImages(firstImage, secondImage)
```

## Efficiency
No data yet
