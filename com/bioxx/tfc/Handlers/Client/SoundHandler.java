/*    */ package com.bioxx.tfc.Handlers.Client;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*    */ import net.minecraft.client.audio.ISound;
/*    */ import net.minecraft.client.audio.PositionedSoundRecord;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.client.event.sound.PlaySoundEvent17;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SoundHandler
/*    */ {
/*    */   private ISound iSound;
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onSound17(PlaySoundEvent17 event) {
/* 20 */     if (event.sound != null && event.category != null && event.category.func_147155_a().equalsIgnoreCase("music"))
/*    */     {
/* 22 */       if (event.manager.func_148597_a(this.iSound)) {
/* 23 */         event.result = null;
/*    */       } else {
/*    */         
/* 26 */         this.iSound = (ISound)PositionedSoundRecord.func_147673_a(new ResourceLocation("terrafirmacraft:music.tfc"));
/* 27 */         event.result = this.iSound;
/*    */       } 
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Handlers\Client\SoundHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */