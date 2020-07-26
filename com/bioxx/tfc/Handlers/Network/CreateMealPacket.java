/*    */ package com.bioxx.tfc.Handlers.Network;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import com.bioxx.tfc.TileEntities.TEFoodPrep;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import io.netty.channel.ChannelHandlerContext;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CreateMealPacket
/*    */   extends AbstractPacket
/*    */ {
/*    */   private byte flag;
/*    */   private int x;
/*    */   private int y;
/*    */   private int z;
/*    */   
/*    */   public CreateMealPacket() {}
/*    */   
/*    */   public CreateMealPacket(int f, TEFoodPrep te) {
/* 23 */     this.flag = (byte)f;
/* 24 */     this.x = te.field_145851_c;
/* 25 */     this.y = te.field_145848_d;
/* 26 */     this.z = te.field_145849_e;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
/* 32 */     buffer.writeByte(this.flag);
/* 33 */     if (this.flag == 0) {
/*    */       
/* 35 */       buffer.writeInt(this.x);
/* 36 */       buffer.writeInt(this.y);
/* 37 */       buffer.writeInt(this.z);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
/* 44 */     this.flag = buffer.readByte();
/* 45 */     if (this.flag == 0) {
/*    */       
/* 47 */       this.x = buffer.readInt();
/* 48 */       this.y = buffer.readInt();
/* 49 */       this.z = buffer.readInt();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void handleClientSide(EntityPlayer player) {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void handleServerSide(EntityPlayer player) {
/* 62 */     if (this.flag == 0) {
/*    */       
/* 64 */       TEFoodPrep te = (TEFoodPrep)player.field_70170_p.func_147438_o(this.x, this.y, this.z);
/* 65 */       TFC_Core.getSkillStats(player).increaseSkill("skill.cooking", 1);
/* 66 */       te.actionCreate(player);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Handlers\Network\CreateMealPacket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */