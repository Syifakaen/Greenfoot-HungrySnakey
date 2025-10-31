import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Level2 extends World
{
    public static int hp = 4;
    public static Score score = new Score(); 
    private Heart heartDisplay;
    private boolean transitioned = false;

    // Batas area spawn
    private final int spawnMinX = 137;
    private final int spawnMaxX = 600;
    private final int spawnMinY = 148;
    private final int spawnMaxY = 295;

        public Level2()
        {
            super(736, 368, 1);
    
            score.setValue(0);               // reset skor
            addObject(score, 80, 45);        // tampilkan skor di layar
    
            heartDisplay = new Heart(4); // nyawa awal
            addObject(heartDisplay, 661, 37);
    
            prepare();                       // tambahkan objek awal
        }
        
        private int getRightEdgeX() {
        return Greenfoot.getRandomNumber(36) + 700; 
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
    if(getObjects(Predator1.class).size() < 3) {
        x = getRightEdgeX();
        y = getSafeRandomY();
        if(isSafeSpawn(x, y)) {
            addObject(new Predator1(), x, y);
        }
    }
}

        if(!transitioned && score.getValue() >= 100){
            transitioned = true;
            Greenfoot.delay(15);
            Greenfoot.setWorld(new Level3());
        }
    }

    public void spawnPredator() {
    int x = Greenfoot.getRandomNumber(36) + 700; // ujung kanan
    int y = getSafeRandomY();
    if (isSafeSpawn(x, y)) {
        addObject(new Predator1(), x, y);
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

        addObject(new Food1(), 321, 189);
        addObject(new Food1(), 471, 236);

        addObject(new Food2(), 723, 227);
        addObject(new Food2(), 498, 305);

        addObject(new Food3(), 546, 173);
        addObject(new Food3(), 391, 287);

        HungerBar hungerBar = new HungerBar();
        hungerBar.setProgress(0);
        addObject(hungerBar,121,45);
        Predator1 predator1 = new Predator1();
        addObject(predator1,585,242);
        Predator1 predator12 = new Predator1();
        addObject(predator12,262,275);
    }

    // Fungsi bantu spawn aman
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