/*    */ package com.bioxx.tfc.api;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class SkillsManager
/*    */ {
/*  8 */   private List<Skill> skillsArray = new ArrayList<Skill>();
/*    */   
/* 10 */   public static SkillsManager instance = new SkillsManager();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void registerSkill(String name, int rate) {
/* 19 */     this.skillsArray.add(new Skill(name, rate));
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Skill> getSkillsArray() {
/* 24 */     return this.skillsArray;
/*    */   }
/*    */ 
/*    */   
/*    */   public Skill getSkill(String name) {
/* 29 */     for (Skill s : this.skillsArray) {
/* 30 */       if (s.skillName.equalsIgnoreCase(name))
/* 31 */         return s; 
/* 32 */     }  return null;
/*    */   }
/*    */   
/*    */   public class Skill
/*    */   {
/*    */     public String skillName;
/*    */     public int skillRate;
/*    */     
/*    */     public Skill(String n, int r) {
/* 41 */       this.skillName = n;
/* 42 */       this.skillRate = r;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\api\SkillsManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */