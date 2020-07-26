/*    */ package com.bioxx.tfc.api.Entities;public interface IAnimal { boolean canFamiliarize(); boolean canMateWith(IAnimal paramIAnimal); boolean checkFamiliarity(InteractionEnum paramInteractionEnum, EntityPlayer paramEntityPlayer); EntityAgeable createChildTFC(EntityAgeable paramEntityAgeable); void familiarize(EntityPlayer paramEntityPlayer); int getAge(); float getAggressionMod(); int getAnimalTypeID(); Vec3 getAttackedVec(); int getBirthDay(); int getDueDay(); EntityLiving getEntity(); int getFamiliarity(); boolean getFamiliarizedToday(); Entity getFearSource(); GenderEnum getGender(); int getHunger(); boolean getInLove(); int getNumberOfDaysToAdult(); float getObedienceMod(); float getSizeMod(); float getStrengthMod(); void handleFamiliarityUpdate(); boolean isAdult(); boolean isFood(ItemStack paramItemStack); boolean isPregnant(); void mate(IAnimal paramIAnimal);
/*    */   void setAge(int paramInt);
/*    */   void setAggressionMod(float paramFloat);
/*    */   void setAttackedVec(Vec3 paramVec3);
/*    */   void setBirthDay(int paramInt);
/*    */   void setFamiliarity(int paramInt);
/*    */   void setFearSource(Entity paramEntity);
/*    */   void setHunger(int paramInt);
/*    */   void setInLove(boolean paramBoolean);
/*    */   void setObedienceMod(float paramFloat);
/*    */   void setSizeMod(float paramFloat);
/*    */   void setStrengthMod(float paramFloat);
/*    */   boolean trySetName(String paramString, EntityPlayer paramEntityPlayer);
/* 14 */   public enum GenderEnum { MALE, FEMALE;
/* 15 */     public static final GenderEnum[] GENDERS = new GenderEnum[] { MALE, FEMALE };
/*    */     static {
/*    */     
/*    */     } }
/*    */   
/* 20 */   public enum InteractionEnum { MOUNT, SHEAR, MILK, BREED, NAME, TOLERATEPLAYER;
/* 21 */     public static final InteractionEnum[] INTERACTIONS = new InteractionEnum[] { MOUNT, SHEAR, MILK, BREED, NAME, TOLERATEPLAYER };
/*    */     
/*    */     static {
/*    */     
/*    */     } }
/*    */    }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\api\Entities\IAnimal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */