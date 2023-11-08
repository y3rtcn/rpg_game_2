import java.util.Scanner;
public class Rpg_Game1 {
    static String heroNameSetting;
    static int hero_number, monster_number;
    Hero[] hero;
    Monster[] monster;
    public static void main(String[] args) {
        Rpg_Game1 gst = new Rpg_Game1();
        gst.gameSetting();
    }
    void gameSetting() {
        int cntgameplay=0;
        hero = new Hero[10];
        hero[1] = new Hero("전사", 1, 15, 20, 100, 20, 0, 0);
        hero[2] = new Hero("마법사", 1, 15, 10, 60, 80, 0, 0);
        hero[3] = new Hero("궁수", 1, 15, 8, 60, 50, 0, 0);
        monster = new Monster[10];
        monster[1] = new Monster("노말 너구리", 300, 0, 1, 20,
                5, 50, 15);
        monster[2] = new Monster("물속성 물의 살쾡이", 700, 0, 1, 100,
                10, 70, 20);
        monster[3] = new Monster("풀속성 풀의 들개", 1000, 0, 1, 300,
                15, 100, 30);
        monster[4] = new Monster("불속성 불의 멧돼지", 3000, 0, 1, 500,
                20, 200, 40);

        Scanner in = new Scanner(System.in);
        System.out.println("*******RPG GAME*******");
        System.out.println("1. 전사");
        System.out.println("2. 마법사");
        System.out.println("3. 궁수");
        System.out.print("직업의 번호를 입력하세요. : ");
        hero_number = in.nextInt();
        System.out.printf("%s가 선택되었습니다.\n", hero[hero_number].hero_name);
        System.out.print("영웅의 이름을 입력하세요. : ");
        heroNameSetting = in.next();
        System.out.println("이름이 입력되었습니다.");
        System.out.println("게임에 입장하였습니다.");
        System.out.println("********************");

        while(true){
            if(cntgameplay == 100000){
                break;
            }
            cntgameplay++;
            System.out.println("현재 " +hero[hero_number].hero_name+ "의 이름 : " + heroNameSetting);
            System.out.println("현재 "+ heroNameSetting + "의 레벨 : " + hero[hero_number].hero_level);
            System.out.println("현재 " +heroNameSetting + "의 힘 : " +hero[hero_number].hero_power);
            System.out.println("현재 "+heroNameSetting+"의 방어력 : " + hero[hero_number].hero_defense);
            System.out.println("현재 "+ heroNameSetting+ "의 HP : " +hero[hero_number].hero_hp);
            System.out.println("현재 "+heroNameSetting+ "의 경험치 : " + hero[hero_number].hero_experience);
            System.out.println("현재 "+heroNameSetting+ "의 돈 : " + hero[hero_number].hero_money);
            System.out.println("********************");
            battle_field();
            checkLevelUp();
        }
    }



    void battle_field() {
        Scanner in = new Scanner(System.in);
        int wherego = 0;
        System.out.println("1. 사냥터");
        System.out.println("2. 포션상점");
        System.out.print("입장할 장소를 선택하세요 : ");
        wherego = in.nextInt();
        if (wherego == 1){
            System.out.println("사냥터에 입장하였습니다.");
            System.out.println("1. 노말 너구리");
            System.out.println("2. 물속성 물의 살쾡이");
            System.out.println("3. 풀속성 풀의 들개");
            System.out.println("4. 불속성 불의 멧돼지");
            System.out.print("전투할 상대를 선택하세요 : ");
            monster_number = in.nextInt();
            System.out.println(monster[monster_number].monster_name+"와 전투를 시작합니다.");
            monster = new Monster[10];
            monster[1] = new Monster("노말 너구리", 300, 0, 1,
                    20, 5, 50, 15);
            monster[2] = new Monster("물속성 물의 살쾡이", 700, 0, 1,
                    100, 10, 70, 20);
            monster[3] = new Monster("풀속성 풀의 들개", 1000, 0, 1,
                    300, 15, 100, 30);
            monster[4] = new Monster("불속성 불의 멧돼지", 3000, 0, 1,
                    500, 20, 200, 40);
            while(true) {
                monster_attacked(hero_attack());
                if(monster[monster_number].monster_hp <= 0){
                    System.out.println(monster[monster_number].monster_name+"가 죽었습니다.");
                    hero[hero_number].hero_experience+=monster[monster_number].monster_experience;
                    hero[hero_number].hero_money+=monster[monster_number].monster_money;
                    break;
                }
                hero_attacked(monster_attack());
                if(hero[hero_number].hero_hp <= 0){
                    System.out.println("당신은 사망하였습니다. 체력 1로 부활합니다.");
                    hero[hero_number].hero_hp = 1;
                    break;
                }
            }
        }
        else if (wherego == 2) {
            PotionStore pss = new PotionStore(hero, hero_number);
        }
    }

    int hero_attack(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(hero[hero_number].hero_name+ "의 공격입니다.");
        if(hero_number == 1) {
            if(hero[hero_number].hero_level == 1) {
                System.out.println("1.나뭇잎베기(물속성 적에게 추가 대미지)");
            }
            else if(hero[hero_number].hero_level == 2){
                System.out.println("1.나뭇잎베기(물속성 적에게 추가 대미지)");
                System.out.println("2.화검류 용각 베기(풀속성 적에게 추가 대미지)");
            }
            else{
                System.out.println("1.나뭇잎베기(물속성 적에게 추가 대미지)");
                System.out.println("2.화검류 용각 베기(풀속성 적에게 추가 대미지)");
                System.out.println("3.포세이돈식 삼지창 찌르기(불속성 적에게 추가 대미지)");
            }

        }
        else if(hero_number == 2) {
            if(hero[hero_number].hero_level == 1) {
                System.out.println("1.비샨티의 풀의 성검(물속성 적에게 추가 대미지)");
            }
            else if(hero[hero_number].hero_level == 2){
                System.out.println("1.비샨티의 풀의 성검(물속성 적에게 추가 대미지)");
                System.out.println("2.호고스의 불마법(풀속성 적에게 추가 대미지)");
            }
            else{
                System.out.println("1.비샨티의 풀의 성검(물속성 적에게 추가 대미지)");
                System.out.println("2.호고스의 불마법(풀속성 적에게 추가 대미지)");
                System.out.println("3.해룡 소환(불속성 적에게 추가 대미지)");
            }
        }
        else if(hero_number == 3){
            if(hero[hero_number].hero_level == 1) {
                System.out.println("1.풀의 화살(물속성 적에게 추가 대미지)");
            }
            else if(hero[hero_number].hero_level == 2){
                System.out.println("1.풀의 화살(물속성 적에게 추가 대미지)");
                System.out.println("2.화염 화살(풀속성 적에게 추가 대미지)");
            }
            else{
                System.out.println("1.풀의 화살(물속성 적에게 추가 대미지)");
                System.out.println("2.화염 화살(풀속성 적에게 추가 대미지)");
                System.out.println("3.해일의 화살(불속성 적에게 추가 대미지)");
            }
        }
        System.out.print("공격 번호를 입력하세요 : ");
        int skn = scanner.nextInt();
        int additional_Damage=0;
        if(monster_number == 1){
            additional_Damage = 0;
        }
        else if(monster_number == 2){
            if(skn == 1){
                additional_Damage = 50;
                System.out.println("상성이 유리하여 추가 대미지를 입힙니다!");
            }
        }
        else if(monster_number == 3){
            if(skn == 2){
                additional_Damage = 50;
                System.out.println("상성이 유리하여 추가 대미지를 입힙니다!");
            }
        }
        else if(monster_number == 4){
            if(skn == 3){
                additional_Damage = 50;
                System.out.println("상성이 유리하여 추가 대미지를 입힙니다!");
            }
        }
        return  hero[hero_number].hero_level * 10 + hero[hero_number].hero_power * 30 + skn*10 + additional_Damage;
    }

    void hero_attacked(int sum){
        if(hero[hero_number].hero_defense>=monster[monster_number].monster_power){
            hero[hero_number].hero_hp+=0;
            System.out.println(monster[monster_number].monster_name + "의 대미지는 0 입니다.");
        }
        else{
            hero[hero_number].hero_hp = hero[hero_number].hero_hp + hero[hero_number].hero_defense - monster[monster_number].monster_power;
            int calc = monster[monster_number].monster_power - hero[hero_number].hero_defense;
            System.out.println(hero[hero_number].hero_name+"의 대미지는 "+calc+"입니다.");
        }
    }

    int monster_attack(){
        System.out.println(monster[monster_number].monster_name+ "의 공격입니다.");
        return monster[monster_number].monster_power;
    }

    void monster_attacked(int sum){
        if(monster[monster_number].monster_defense>=sum){
            monster[monster_number].monster_hp+=0;
            System.out.println(monster[monster_number].monster_name + "의 대미지는 0 입니다.");
        }
        else{
            monster[monster_number].monster_hp = monster[monster_number].monster_hp + monster[monster_number].monster_defense - sum;
            int calcc = sum - monster[monster_number].monster_defense;
            System.out.println(monster[monster_number].monster_name+"의 대미지는 "+calcc+"입니다.");
        }
    }

    void checkLevelUp() {
        if (hero[hero_number].hero_experience >= hero[hero_number].hero_level * 80) {
            hero[hero_number].hero_level++;
            System.out.println(heroNameSetting+ "의 레벨이 "+hero[hero_number].hero_level+"이 되었습니다.");
            hero[hero_number].hero_money += 100;
            System.out.println("레벨업 기념으로 돈이 100원 증가하여" + hero[hero_number].hero_money+"원이 되었습니다.");
        }
    }
}

class Hero {
    int hero_level, hero_power, hero_hp, hero_defense, hero_mp, hero_experience, hero_money;
    String hero_name;
    Hero(String hero_name, int hero_level, int hero_power, int hero_defense, int hero_hp, int hero_mp,
         int hero_experience, int hero_money) {
        this.hero_name = hero_name;
        this.hero_level = hero_level;
        this.hero_power = hero_power;
        this.hero_defense = hero_defense;
        this.hero_hp = hero_hp;
        this.hero_mp = hero_mp;
        this.hero_experience = hero_experience;
        this.hero_money = hero_money;
    }
}

class Monster {
    int monster_hp, monster_mp, monster_level, monster_power, monster_defense, monster_money, monster_experience;
    String monster_name;
    Monster(String monster_name, int monster_hp, int monster_mp, int monster_level, int monster_power, int monster_defense,
            int monster_money, int monster_experience) {
        this.monster_name = monster_name;
        this.monster_hp = monster_hp;
        this.monster_mp = monster_mp;
        this.monster_level = monster_level;
        this.monster_power = monster_power;
        this.monster_defense = monster_defense;
        this.monster_money = monster_money;
        this.monster_experience = monster_experience;
    }
}

class PotionStore {
    PotionStore(Hero[] hero, int hero_number) {
        int pscs = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("포션 상점에 입장하였습니다.");
        System.out.println(hero[hero_number].hero_money+"원 보유중입니다.");
        System.out.println("1. 힘 증강 포션 (30원)");
        System.out.println("2. 방어력 증강 포션 (30원)");
        System.out.println("3. 경험치 증강 포션 (100원)");
        System.out.println("4. HP 증강 포션 (10원)");
        System.out.println("5. MP 증강 포션 (10원)");
        System.out.println("6. 상점에서 나가기");
        System.out.print("원하시는 물건을 입력하세요. : ");
        pscs = in.nextInt();
        if (pscs == 1 && hero[hero_number].hero_money >= 30) {
            hero[hero_number].hero_power += 100;
            hero[hero_number].hero_money -= 30;
            System.out.println("포션 상점에서 물건을 구매 시도하는 중입니다.");
            System.out.println(("힘 증간 포션 구입이 완료되었습니다.(힘+100)"));
        }
        else if (pscs == 2 && hero[hero_number].hero_money >= 30) {
            hero[hero_number].hero_defense += 100;
            hero[hero_number].hero_money -= 30;
            System.out.println("포션 상점에서 물건을 구매 시도하는 중입니다.");
            System.out.println(("방어력 증강 포션 구입이 완료되었습니다.(방어력+100)"));
        }
        else if (pscs == 3 && hero[hero_number].hero_money >= 100) {
            hero[hero_number].hero_experience += 50;
            hero[hero_number].hero_money -= 100;
            System.out.println("포션 상점에서 물건을 구매 시도하는 중입니다.");
            System.out.println(("경험치 증강 포션 구입이 완료되었습니다.(경험치+50)"));
        }
        else if (pscs == 4 && hero[hero_number].hero_money >= 10) {
            hero[hero_number].hero_hp += 100;
            hero[hero_number].hero_money -= 10;
            System.out.println("포션 상점에서 물건을 구매 시도하는 중입니다.");
            System.out.println(("HP 증강 포션 구입이 완료되었습니다.(HP+50)"));
        }

        else if (pscs == 5 && hero[hero_number].hero_money >= 10) {
            hero[hero_number].hero_mp += 50;
            hero[hero_number].hero_money -= 10;
            System.out.println("포션 상점에서 물건을 구매 시도하는 중입니다.");
            System.out.println(("MP 증강 포션 구입이 완료되었습니다.(MP+50)"));
        }
        else if(pscs == 6){
            pscs = 0;
        }
        else {
            System.out.println("돈이 부족합니다.");
        }
        System.out.println(hero[hero_number].hero_money+"원 남았습니다.");
        System.out.println("**********************");
    }
}
