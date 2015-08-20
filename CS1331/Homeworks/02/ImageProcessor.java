public class ImageProcessor {
    private Pic picture;
    private Pic otherPic;
    private Pixel[][] p;
    private Pixel[][] q;


    public ImageProcessor(Pic picture) {
        this.picture = picture;
    }


    public Pic grayscale() {
        Pic pic1 = picture.deepCopy();
        for (int x = 0; x < pic1.getHeight(); x++) {
            for (int y = 0; y < pic1.getWidth(); y++) {
                p = pic1.getPixels();
                int red = p[x][y].getRed();
                int green = p[x][y].getGreen();
                int blue = p[x][y].getBlue();
                int gray = (red + green + blue) / 3;
                p[x][y].setRed(gray);
                p[x][y].setGreen(gray);
                p[x][y].setBlue(gray);
            }
        }
        return pic1;

    }


    public Pic invert() {
        Pic pic2 = picture.deepCopy();
        for (int x = 0; x < pic2.getHeight(); x++) {
            for (int y = 0; y < pic2.getWidth(); y++) {
                p = pic2.getPixels();
                int red = p[x][y].getRed();
                int green = p[x][y].getGreen();
                int blue = p[x][y].getBlue();
                int r = 255 - red;
                int g = 255 - green;
                int b = 255 - blue;
                p[x][y].setRed(r);
                p[x][y].setGreen(g);
                p[x][y].setBlue(b);
            }
        }
        return pic2;

    }


    public Pic noRed() {
        Pic pic3 = picture.deepCopy();
        for (int x = 0; x < pic3.getHeight(); x++) {
            for (int y = 0; y < pic3.getWidth(); y++) {
                p = pic3.getPixels();
                int red = p[x][y].getRed();
                int green = p[x][y].getGreen();
                int blue = p[x][y].getBlue();
                p[x][y].setRed(0);
                p[x][y].setGreen(green);
                p[x][y].setBlue(blue);
            }
        }
        return pic3;
    }


    public Pic blackAndWhite() {
        Pic pic4 = picture.deepCopy();
        for (int x = 0; x < pic4.getHeight(); x++) {
            for (int y = 0; y < pic4.getWidth(); y++) {
                p = pic4.getPixels();
                int red = p[x][y].getRed();
                int green = p[x][y].getGreen();
                int blue = p[x][y].getBlue();
                int gray = (red + green + blue) / 3;
                if (gray > 127) {
                    p[x][y].setRed(255);
                    p[x][y].setGreen(255);
                    p[x][y].setBlue(255);
                } else {
                    p[x][y].setRed(0);
                    p[x][y].setGreen(0);
                    p[x][y].setBlue(0);
                }
            }
        }
        return pic4;

    }


    public Pic maximize() {
        Pic pic5 = picture.deepCopy();
        for (int x = 0; x < pic5.getHeight(); x++) {
            for (int y = 0; y < pic5.getWidth(); y++) {
                p = pic5.getPixels();
                int red = p[x][y].getRed();
                int green = p[x][y].getGreen();
                int blue = p[x][y].getBlue();
                if (red > green & red > blue) {
                    p[x][y].setRed(red);
                    p[x][y].setGreen(0);
                    p[x][y].setBlue(0);
                } else if (green > blue & green > red) {
                    p[x][y].setRed(0);
                    p[x][y].setGreen(green);
                    p[x][y].setBlue(0);
                } else if (blue > green & blue > red) {
                    p[x][y].setRed(0);
                    p[x][y].setGreen(0);
                    p[x][y].setBlue(blue);
                } else if (blue == green & blue != red) {
                    int average = (blue + green) / 2;
                    p[x][y].setRed(0);
                    p[x][y].setGreen(average);
                    p[x][y].setBlue(average);
                } else if (blue == red & blue != green) {
                    int average = (blue + red) / 2;
                    p[x][y].setRed(average);
                    p[x][y].setGreen(0);
                    p[x][y].setBlue(average);
                } else if (red == green & red != blue) {
                    int average = (red + green) / 2;
                    p[x][y].setRed(average);
                    p[x][y].setGreen(average);
                    p[x][y].setBlue(0);
                } else {
                    p[x][y].setRed(red);
                    p[x][y].setGreen(green);
                    p[x][y].setBlue(blue);
                }
            }
        }
        return pic5;
    }



    public Pic overlay(Pic other) {
        Pic pic6 = picture.deepCopy();
        p = pic6.getPixels();
        q = other.getPixels();
        int pHeight = pic6.getHeight();
        int qHeight = other.getHeight();
        int pWidth = pic6.getWidth();
        int qWidth = other.getWidth();
        for (int x = 0; x < pHeight & x < qHeight; x++) {
            for (int y = 0; y < pWidth & y < qWidth; y++) {

                Pixel pPixel = p[x][y];
                Pixel qPixel = q[x][y];

                int red = pPixel.getRed();
                int green = pPixel.getGreen();
                int blue = pPixel.getBlue();
                int red1 = qPixel.getRed();
                int green1 = qPixel.getGreen();
                int blue1 = qPixel.getBlue();
                int avgRed = (red + red1) / 2;
                int avgGreen = (green + green1) / 2;
                int avgBlue = (blue + blue1) / 2;
                pPixel.setRed(avgRed);
                pPixel.setGreen(avgGreen);
                pPixel.setBlue(avgBlue);
            }
        }
        return pic6;


    }


    public static void main(String[] args) {
        String filename = args[0];
        Pic newPic = new Pic(filename);
        ImageProcessor picture = new ImageProcessor(newPic);
        Pic gray = picture.grayscale();
        gray.show();
        Pic invert = picture.invert();
        invert.show();
        Pic blackAndWhite = picture.blackAndWhite();
        blackAndWhite.show();
        Pic maximize = picture.maximize();
        maximize.show();
        Pic noRed = picture.noRed();
        noRed.show();


        if (args.length > 1) {
            String otherFile = args[1];
            Pic otherPicture = new Pic(otherFile);
            ImageProcessor otherPic = new ImageProcessor(otherPicture);
            Pic overLay = picture.overlay(otherPicture);
            overLay.show();

        }
    }
}
