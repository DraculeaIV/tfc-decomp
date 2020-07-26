/*     */ package com.bioxx.tfc.Handlers.Network;
/*     */ 
/*     */ import com.bioxx.tfc.Core.Player.FoodStatsTFC;
/*     */ import com.bioxx.tfc.Core.Player.PlayerInfo;
/*     */ import com.bioxx.tfc.Core.Player.PlayerInventory;
/*     */ import com.bioxx.tfc.Core.Player.PlayerManagerTFC;
/*     */ import com.bioxx.tfc.Core.Player.SkillStats;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import cpw.mods.fml.common.network.ByteBufUtils;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import io.netty.channel.ChannelHandlerContext;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ 
/*     */ public class InitClientWorldPacket
/*     */   extends AbstractPacket {
/*     */   private long seed;
/*     */   private long soberTime;
/*     */   private float stomachLevel;
/*     */   private float waterLevel;
/*     */   private float nutrFruit;
/*     */   private float nutrVeg;
/*     */   private float nutrGrain;
/*     */   private float nutrProtein;
/*     */   private float nutrDairy;
/*     */   private boolean craftingTable;
/*     */   private SkillStats playerSkills;
/*  31 */   private Map<String, Integer> skillMap = new HashMap<String, Integer>(); private byte chiselMode; private boolean debugMode; private int daysInYear;
/*     */   private int healthGainRate;
/*     */   private int healthGainCap;
/*     */   private int maxProtectionMonths;
/*     */   private int protectionGain;
/*     */   private int protectionBuffer;
/*     */   private int smallOreUnits;
/*     */   private int poorOreUnits;
/*     */   private int normalOreUnits;
/*     */   private int richOreUnits;
/*     */   private int torchBurnTime;
/*     */   
/*     */   public InitClientWorldPacket(EntityPlayer p) {
/*  44 */     this.seed = p.field_70170_p.func_72905_C();
/*     */     
/*  46 */     TFC_Time.updateTime(p.field_70170_p);
/*  47 */     FoodStatsTFC fs = TFC_Core.getPlayerFoodStats(p);
/*  48 */     fs.resetTimers();
/*  49 */     fs.writeNBT(p.getEntityData());
/*  50 */     this.stomachLevel = fs.stomachLevel;
/*  51 */     this.waterLevel = fs.waterLevel;
/*  52 */     this.soberTime = fs.soberTime;
/*  53 */     this.nutrFruit = fs.nutrFruit;
/*  54 */     this.nutrVeg = fs.nutrVeg;
/*  55 */     this.nutrGrain = fs.nutrGrain;
/*  56 */     this.nutrProtein = fs.nutrProtein;
/*  57 */     this.nutrDairy = fs.nutrDairy;
/*     */ 
/*     */     
/*  60 */     this.debugMode = TFCOptions.enableDebugMode;
/*  61 */     this.daysInYear = TFCOptions.yearLength;
/*  62 */     this.healthGainRate = TFCOptions.healthGainRate;
/*  63 */     this.healthGainCap = TFCOptions.healthGainCap;
/*  64 */     this.maxProtectionMonths = TFCOptions.maxProtectionMonths;
/*  65 */     this.protectionGain = TFCOptions.protectionGain;
/*  66 */     this.protectionBuffer = TFCOptions.protectionBuffer;
/*  67 */     this.smallOreUnits = TFCOptions.smallOreUnits;
/*  68 */     this.poorOreUnits = TFCOptions.poorOreUnits;
/*  69 */     this.normalOreUnits = TFCOptions.normalOreUnits;
/*  70 */     this.richOreUnits = TFCOptions.richOreUnits;
/*  71 */     this.pitKilnBurnTime = TFCOptions.pitKilnBurnTime;
/*  72 */     this.bloomeryBurnTime = TFCOptions.bloomeryBurnTime;
/*  73 */     this.charcoalPitBurnTime = TFCOptions.charcoalPitBurnTime;
/*  74 */     this.torchBurnTime = TFCOptions.torchBurnTime;
/*  75 */     this.saplingTimerMultiplier = TFCOptions.saplingTimerMultiplier;
/*  76 */     this.oilLampFuelMult = TFCOptions.oilLampFuelMult;
/*  77 */     this.animalTimeMultiplier = TFCOptions.animalTimeMultiplier;
/*     */ 
/*     */     
/*  80 */     if (p.getEntityData().func_74764_b("craftingTable"))
/*  81 */       this.craftingTable = true; 
/*  82 */     this.playerSkills = TFC_Core.getSkillStats(p);
/*  83 */     this.chiselMode = (PlayerManagerTFC.getInstance().getPlayerInfoFromPlayer(p)).chiselMode;
/*     */   }
/*     */   private int oilLampFuelMult;
/*     */   private float pitKilnBurnTime;
/*     */   
/*     */   public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
/*  89 */     buffer.writeLong(this.seed);
/*  90 */     buffer.writeFloat(this.stomachLevel);
/*  91 */     buffer.writeFloat(this.waterLevel);
/*  92 */     buffer.writeLong(this.soberTime);
/*  93 */     buffer.writeFloat(this.nutrFruit);
/*  94 */     buffer.writeFloat(this.nutrVeg);
/*  95 */     buffer.writeFloat(this.nutrGrain);
/*  96 */     buffer.writeFloat(this.nutrProtein);
/*  97 */     buffer.writeFloat(this.nutrDairy);
/*  98 */     buffer.writeBoolean(this.craftingTable);
/*  99 */     this.playerSkills.toOutBuffer(buffer);
/* 100 */     buffer.writeByte(this.chiselMode);
/*     */ 
/*     */     
/* 103 */     buffer.writeBoolean(this.debugMode);
/* 104 */     buffer.writeInt(this.daysInYear);
/* 105 */     buffer.writeInt(this.healthGainRate);
/* 106 */     buffer.writeInt(this.healthGainCap);
/* 107 */     buffer.writeInt(this.maxProtectionMonths);
/* 108 */     buffer.writeInt(this.protectionGain);
/* 109 */     buffer.writeInt(this.protectionBuffer);
/* 110 */     buffer.writeInt(this.smallOreUnits);
/* 111 */     buffer.writeInt(this.poorOreUnits);
/* 112 */     buffer.writeInt(this.normalOreUnits);
/* 113 */     buffer.writeInt(this.richOreUnits);
/* 114 */     buffer.writeInt(this.torchBurnTime);
/* 115 */     buffer.writeInt(this.oilLampFuelMult);
/* 116 */     buffer.writeFloat(this.pitKilnBurnTime);
/* 117 */     buffer.writeFloat(this.bloomeryBurnTime);
/* 118 */     buffer.writeFloat(this.charcoalPitBurnTime);
/* 119 */     buffer.writeFloat(this.saplingTimerMultiplier);
/* 120 */     buffer.writeFloat(this.animalTimeMultiplier);
/*     */   }
/*     */   private float bloomeryBurnTime;
/*     */   private float charcoalPitBurnTime;
/*     */   
/*     */   public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
/* 126 */     this.seed = buffer.readLong();
/* 127 */     this.stomachLevel = buffer.readFloat();
/* 128 */     this.waterLevel = buffer.readFloat();
/* 129 */     this.soberTime = buffer.readLong();
/* 130 */     this.nutrFruit = buffer.readFloat();
/* 131 */     this.nutrVeg = buffer.readFloat();
/* 132 */     this.nutrGrain = buffer.readFloat();
/* 133 */     this.nutrProtein = buffer.readFloat();
/* 134 */     this.nutrDairy = buffer.readFloat();
/* 135 */     this.craftingTable = buffer.readBoolean();
/*     */     
/* 137 */     this.skillMap.clear();
/*     */ 
/*     */     
/* 140 */     int size = buffer.readInt();
/* 141 */     for (int l = 0; l < size; l++) {
/*     */       
/* 143 */       String name = ByteBufUtils.readUTF8String(buffer);
/* 144 */       int lvl = buffer.readInt();
/* 145 */       this.skillMap.put(name, Integer.valueOf(lvl));
/*     */     } 
/*     */     
/* 148 */     this.chiselMode = buffer.readByte();
/*     */ 
/*     */     
/* 151 */     this.debugMode = buffer.readBoolean();
/* 152 */     this.daysInYear = buffer.readInt();
/* 153 */     this.healthGainRate = buffer.readInt();
/* 154 */     this.healthGainCap = buffer.readInt();
/* 155 */     this.maxProtectionMonths = buffer.readInt();
/* 156 */     this.protectionGain = buffer.readInt();
/* 157 */     this.protectionBuffer = buffer.readInt();
/* 158 */     this.smallOreUnits = buffer.readInt();
/* 159 */     this.poorOreUnits = buffer.readInt();
/* 160 */     this.normalOreUnits = buffer.readInt();
/* 161 */     this.richOreUnits = buffer.readInt();
/* 162 */     this.torchBurnTime = buffer.readInt();
/* 163 */     this.oilLampFuelMult = buffer.readInt();
/* 164 */     this.pitKilnBurnTime = buffer.readFloat();
/* 165 */     this.bloomeryBurnTime = buffer.readFloat();
/* 166 */     this.charcoalPitBurnTime = buffer.readFloat();
/* 167 */     this.saplingTimerMultiplier = buffer.readFloat();
/* 168 */     this.animalTimeMultiplier = buffer.readFloat();
/*     */   }
/*     */   private float saplingTimerMultiplier; private float animalTimeMultiplier;
/*     */   public InitClientWorldPacket() {}
/*     */   
/*     */   public void handleClientSide(EntityPlayer player) {
/* 174 */     FoodStatsTFC fs = TFC_Core.getPlayerFoodStats(player);
/* 175 */     fs.stomachLevel = this.stomachLevel;
/* 176 */     fs.waterLevel = this.waterLevel;
/* 177 */     fs.soberTime = this.soberTime;
/* 178 */     fs.nutrFruit = this.nutrFruit;
/* 179 */     fs.nutrVeg = this.nutrVeg;
/* 180 */     fs.nutrProtein = this.nutrProtein;
/* 181 */     fs.nutrDairy = this.nutrDairy;
/* 182 */     TFC_Core.setPlayerFoodStats(player, fs);
/*     */     
/* 184 */     if (this.craftingTable) {
/*     */       
/* 186 */       player.getEntityData().func_74757_a("craftingTable", this.craftingTable);
/* 187 */       PlayerInventory.upgradePlayerCrafting(player);
/*     */     } 
/* 189 */     TFC_Core.setupWorld(player.field_70170_p, this.seed);
/*     */     
/* 191 */     this.playerSkills = TFC_Core.getSkillStats(player);
/* 192 */     for (String skill : this.skillMap.keySet())
/*     */     {
/* 194 */       this.playerSkills.setSkillSave(skill, ((Integer)this.skillMap.get(skill)).intValue());
/*     */     }
/* 196 */     this.skillMap.clear();
/*     */     
/* 198 */     (PlayerManagerTFC.getInstance()).players.add(new PlayerInfo(player
/* 199 */           .func_70005_c_(), player
/* 200 */           .func_110124_au()));
/*     */     
/* 202 */     PlayerManagerTFC.getInstance().getClientPlayer().setChiselMode(this.chiselMode);
/*     */ 
/*     */     
/* 205 */     TFCOptions.enableDebugMode = this.debugMode;
/* 206 */     TFC_Time.setYearLength(this.daysInYear);
/* 207 */     TFCOptions.healthGainRate = this.healthGainRate;
/* 208 */     TFCOptions.healthGainCap = this.healthGainCap;
/* 209 */     TFCOptions.maxProtectionMonths = this.maxProtectionMonths;
/* 210 */     TFCOptions.protectionGain = this.protectionGain;
/* 211 */     TFCOptions.protectionBuffer = this.protectionBuffer;
/* 212 */     TFCOptions.smallOreUnits = this.smallOreUnits;
/* 213 */     TFCOptions.poorOreUnits = this.poorOreUnits;
/* 214 */     TFCOptions.normalOreUnits = this.normalOreUnits;
/* 215 */     TFCOptions.richOreUnits = this.richOreUnits;
/* 216 */     TFCOptions.torchBurnTime = this.torchBurnTime;
/* 217 */     TFCOptions.oilLampFuelMult = this.oilLampFuelMult;
/* 218 */     TFCOptions.pitKilnBurnTime = this.pitKilnBurnTime;
/* 219 */     TFCOptions.bloomeryBurnTime = this.bloomeryBurnTime;
/* 220 */     TFCOptions.charcoalPitBurnTime = this.charcoalPitBurnTime;
/* 221 */     TFCOptions.saplingTimerMultiplier = this.saplingTimerMultiplier;
/* 222 */     TFCOptions.animalTimeMultiplier = this.animalTimeMultiplier;
/*     */   }
/*     */   
/*     */   public void handleServerSide(EntityPlayer player) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Handlers\Network\InitClientWorldPacket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */