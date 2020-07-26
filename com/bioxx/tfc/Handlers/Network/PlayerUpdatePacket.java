/*     */ package com.bioxx.tfc.Handlers.Network;
/*     */ 
/*     */ import com.bioxx.tfc.Core.Player.FoodStatsTFC;
/*     */ import com.bioxx.tfc.Core.Player.PlayerInventory;
/*     */ import com.bioxx.tfc.Core.Player.SkillStats;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import cpw.mods.fml.common.network.ByteBufUtils;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import io.netty.channel.ChannelHandlerContext;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PlayerUpdatePacket
/*     */   extends AbstractPacket
/*     */ {
/*     */   private byte flag;
/*     */   private float stomachLevel;
/*     */   private float waterLevel;
/*     */   private long soberTime;
/*     */   private float nutrFruit;
/*     */   private float nutrVeg;
/*     */   private float nutrGrain;
/*     */   private float nutrProtein;
/*     */   private float nutrDairy;
/*     */   private SkillStats playerSkills;
/*     */   private String skillName;
/*     */   private int skillLevel;
/*     */   private boolean craftingTable;
/*  35 */   private Map<String, Integer> skillMap = new HashMap<String, Integer>();
/*     */ 
/*     */   
/*     */   public PlayerUpdatePacket() {}
/*     */   
/*     */   public PlayerUpdatePacket(EntityPlayer p, int f) {
/*  41 */     this.flag = (byte)f;
/*  42 */     if (this.flag == 0) {
/*     */       
/*  44 */       FoodStatsTFC fs = TFC_Core.getPlayerFoodStats(p);
/*  45 */       this.stomachLevel = fs.stomachLevel;
/*  46 */       this.waterLevel = fs.waterLevel;
/*  47 */       this.soberTime = fs.soberTime;
/*  48 */       this.nutrFruit = fs.nutrFruit;
/*  49 */       this.nutrVeg = fs.nutrVeg;
/*  50 */       this.nutrGrain = fs.nutrGrain;
/*  51 */       this.nutrProtein = fs.nutrProtein;
/*  52 */       this.nutrDairy = fs.nutrDairy;
/*     */     }
/*  54 */     else if (this.flag == 2) {
/*     */       
/*  56 */       this.craftingTable = p.getEntityData().func_74767_n("craftingTable");
/*     */     }
/*  58 */     else if (this.flag == 3) {
/*     */       
/*  60 */       this.playerSkills = TFC_Core.getSkillStats(p);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PlayerUpdatePacket(int f, String name, int lvl) {
/*  70 */     this.flag = (byte)f;
/*  71 */     if (this.flag == 1) {
/*     */       
/*  73 */       this.skillName = name;
/*  74 */       this.skillLevel = lvl;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
/*  81 */     buffer.writeByte(this.flag);
/*  82 */     if (this.flag == 0) {
/*     */       
/*  84 */       buffer.writeFloat(this.stomachLevel);
/*  85 */       buffer.writeFloat(this.waterLevel);
/*  86 */       buffer.writeLong(this.soberTime);
/*  87 */       buffer.writeFloat(this.nutrFruit);
/*  88 */       buffer.writeFloat(this.nutrVeg);
/*  89 */       buffer.writeFloat(this.nutrGrain);
/*  90 */       buffer.writeFloat(this.nutrProtein);
/*  91 */       buffer.writeFloat(this.nutrDairy);
/*     */     }
/*  93 */     else if (this.flag == 1) {
/*     */       
/*  95 */       ByteBufUtils.writeUTF8String(buffer, this.skillName);
/*  96 */       buffer.writeInt(this.skillLevel);
/*     */     }
/*  98 */     else if (this.flag == 2) {
/*     */       
/* 100 */       buffer.writeBoolean(this.craftingTable);
/*     */     }
/* 102 */     else if (this.flag == 3) {
/*     */       
/* 104 */       this.playerSkills.toOutBuffer(buffer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
/* 115 */     this.flag = buffer.readByte();
/* 116 */     if (this.flag == 0) {
/*     */       
/* 118 */       this.stomachLevel = buffer.readFloat();
/* 119 */       this.waterLevel = buffer.readFloat();
/* 120 */       this.soberTime = buffer.readLong();
/* 121 */       this.nutrFruit = buffer.readFloat();
/* 122 */       this.nutrVeg = buffer.readFloat();
/* 123 */       this.nutrGrain = buffer.readFloat();
/* 124 */       this.nutrProtein = buffer.readFloat();
/* 125 */       this.nutrDairy = buffer.readFloat();
/*     */     }
/* 127 */     else if (this.flag == 1) {
/*     */       
/* 129 */       this.skillName = ByteBufUtils.readUTF8String(buffer);
/* 130 */       this.skillLevel = buffer.readInt();
/*     */     }
/* 132 */     else if (this.flag == 2) {
/*     */       
/* 134 */       this.craftingTable = buffer.readBoolean();
/*     */     }
/* 136 */     else if (this.flag == 3) {
/*     */       
/* 138 */       this.skillMap.clear();
/*     */ 
/*     */       
/* 141 */       int size = buffer.readInt();
/* 142 */       for (int l = 0; l < size; l++) {
/*     */         
/* 144 */         String name = ByteBufUtils.readUTF8String(buffer);
/* 145 */         int lvl = buffer.readInt();
/* 146 */         this.skillMap.put(name, Integer.valueOf(lvl));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleClientSide(EntityPlayer player) {
/* 158 */     if (this.flag == 0) {
/*     */       
/* 160 */       FoodStatsTFC fs = TFC_Core.getPlayerFoodStats(player);
/* 161 */       fs.stomachLevel = this.stomachLevel;
/* 162 */       fs.waterLevel = this.waterLevel;
/* 163 */       fs.soberTime = this.soberTime;
/* 164 */       fs.nutrFruit = this.nutrFruit;
/* 165 */       fs.nutrVeg = this.nutrVeg;
/* 166 */       fs.nutrGrain = this.nutrGrain;
/* 167 */       fs.nutrProtein = this.nutrProtein;
/* 168 */       fs.nutrDairy = this.nutrDairy;
/* 169 */       TFC_Core.setPlayerFoodStats(player, fs);
/*     */     }
/* 171 */     else if (this.flag == 1) {
/*     */       
/* 173 */       this.playerSkills = TFC_Core.getSkillStats(player);
/* 174 */       this.playerSkills.setSkillSave(this.skillName, this.skillLevel);
/*     */     }
/* 176 */     else if (this.flag == 2) {
/*     */       
/* 178 */       if (this.craftingTable && !player.getEntityData().func_74764_b("craftingTable"))
/*     */       {
/* 180 */         player.getEntityData().func_74757_a("craftingTable", this.craftingTable);
/* 181 */         PlayerInventory.upgradePlayerCrafting(player);
/*     */       }
/*     */     
/* 184 */     } else if (this.flag == 3) {
/*     */       
/* 186 */       this.playerSkills = TFC_Core.getSkillStats(player);
/* 187 */       for (String skill : this.skillMap.keySet())
/*     */       {
/* 189 */         this.playerSkills.setSkillSave(skill, ((Integer)this.skillMap.get(skill)).intValue());
/*     */       }
/* 191 */       this.skillMap.clear();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleServerSide(EntityPlayer player) {
/* 202 */     if (this.flag == 4) {
/*     */       
/* 204 */       AbstractPacket pkt = new PlayerUpdatePacket(player, 3);
/* 205 */       TerraFirmaCraft.PACKET_PIPELINE.sendTo(pkt, (EntityPlayerMP)player);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Handlers\Network\PlayerUpdatePacket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */