import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Level3 extends World
{
    public static int hp = 4;
    public static Score score = new Score(); // custom Score actor
    private Heart heartDisplay;
    private boolean transitioned = false;

    // 🔒 Batas area spawn
    private final int spawnMinX = 137;
    private final int spawnMaxX = 600;
    private final int spawnMinY = 148;
    private final int spawnMaxY = 295;

    public Level3()
    {
        super(736, 368, 1);

        score.setValue(0);               // reset skor
        addObject(score, 80, 45);        // tampilkan skor di layar

        heartDisplay = new Heart(4); // nyawa awal
        addObject(heartDisplay, 661, 37);

        prepare();                       // tambahkan objek awal
    }
    
    private int getRightEdgeX() {
    return Greenfoot.getRandomNumber(36) + 700; // 700–735
}


    public void act()
    {
        int x, y;

        if(Greenfoot.getRandomNumber(90) < 3){
    if(getObjects(Food1.class).size() < 3) {
        x = getSafeRandomX();
        y = getSafeRandomY();
        if(isSafeSpawn(x, y)) {
            addObject(new Food1(), x, y);
        }
    }
}

if(Greenfoot.getRandomNumber(90) < 3){
    if(getObjects(Food2.class).size() < 3) {
        x = getRightEdgeX();
        y = getSafeRandomY();
        if(isSafeSpawn(x, y)) {
            addObject(new Food2(), x, y);
        }
    }
}

if(Greenfoot.getRandomNumber(90) < 3){
    if(getObjects(Food3.class).size() < 3) {
        x = getRightEdgeX();
        y = getSafeRandomY();
        if(isSafeSpawn(x, y)) {
            addObject(new Food3(), x, y);
        }
    }
}

if(Greenfoot.getRandomNumber(90) < 3){
    if(getObjects(Predator1.class).size() < 2) {
        x = getRightEdgeX();
        y = getSafeRandomY();
        if(isSafeSpawn(x, y)) {
            addObject(new Predator1(), x, y);
        }
    }
}

if(Greenfoot.getRandomNumber(90) < 3){
    if(getObjects(Predator2.class).isEmpty()) {
        x = getRightEdgeX();
        y = getSafeRandomY();
        if(isSafeSpawn(x, y)) {
            addObject(new Predator2(), x, y);
        }
    }
}

        if(!transitioned && score.getValue() >= 100){
            transitioned = true;
            Greenfoot.delay(15);
            Greenfoot.setWorld(new WinPage());
        }
    }

    public void spawnPredator() {
    int x = Greenfoot.getRandomNumber(36) + 700; // ujung kanan
    int y = getSafeRandomY();
    if (isSafeSpawn(x, y)) {
        addObject(new Predator1(), x, y);
        addObject(new Predator2(), x, y);
    }
}
    
    public void loseHp(int amount)
    {
        heartDisplay.loseHp(amount);

        if(heartDisplay.getHp() <= 0){
            Greenfoot.setWorld(new OverPage());
        }
    }



    private void prepare()
    {
        addObject(new Snakey(), 32, 203);


        HungerBar hungerBar = new HungerBar();
        hungerBar.setProgress(0);
        addObject(hungerBar,121,45);
        Food3 food3 = new Food3();
        addObject(food3,404,314);
        Food3 food32 = new Food3();
        addObject(food32,598,181);
        Food1 food1 = new Food1();
        addObject(food1,716,130);
        Food1 food12 = new Food1();
        addObject(food12,334,173);
        Food2 food2 = new Food2();
        addObject(food2,499,257);
        Predator1 predator1 = new Predator1();
        addObject(predator1,279,325);
    }

    //Fungsi bantu spawn aman
    private boolean isSafeSpawn(int x, int y)
    {
        Snakey snakey = (Snakey)getObjects(Snakey.class).get(0);
        int sx = snakey.getX();
        int sy = snakey.getY();

        int dx = Math.abs(x - sx);
        int dy = Math.abs(y - sy);

        return dx > 50 || dy > 50; // minimal jarak dari Snakey
    }

    private int getSafeRandomX() {
        return Greenfoot.getRandomNumber(spawnMaxX - spawnMinX) + spawnMinX;
    }

    private int getSafeRandomY() {
        return Greenfoot.getRandomNumber(spawnMaxY - spawnMinY) + spawnMinY;
    }
}