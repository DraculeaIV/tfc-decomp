/*     */ package com.bioxx.tfc.TileEntities;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.BlockDetailed;
/*     */ import com.bioxx.tfc.Core.Player.PlayerManagerTFC;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import java.util.BitSet;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ 
/*     */ public class TEDetailed
/*     */   extends NetworkTileEntity
/*     */ {
/*  12 */   public short typeID = -1;
/*     */   public byte metaID;
/*     */   public BitSet data;
/*     */   public static final byte PACKET_UPDATE = 0;
/*     */   public static final byte PACKET_ACTIVATE = 1;
/*  17 */   protected byte packetType = -1;
/*     */   private BitSet quads;
/*     */   
/*     */   public TEDetailed() {
/*  21 */     this.data = new BitSet(512);
/*  22 */     this.quads = new BitSet(8);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canUpdate() {
/*  27 */     return false;
/*     */   }
/*     */   
/*     */   public int getType() {
/*  31 */     return this.typeID;
/*     */   }
/*     */   
/*     */   public int getMeta() {
/*  35 */     return this.metaID;
/*     */   }
/*     */   
/*     */   public boolean getBlockExists(int x, int y, int z) {
/*  39 */     return this.data.get((x * 8 + z) * 8 + y);
/*     */   }
/*     */   
/*     */   public void setBlock(int x, int y, int z) {
/*  43 */     this.data.set((x * 8 + z) * 8 + y);
/*     */   }
/*     */   
/*     */   public void setQuad(int x, int y, int z) {
/*  47 */     int x1 = (x >= 4) ? 1 : 0;
/*  48 */     int y1 = (y >= 4) ? 1 : 0;
/*  49 */     int z1 = (z >= 4) ? 1 : 0;
/*  50 */     int index = (x1 * 2 + z1) * 2 + y1;
/*  51 */     this.quads.set(index);
/*     */   }
/*     */   
/*     */   public void clearQuad(int x, int y, int z) {
/*  55 */     int x1 = (x >= 4) ? 1 : 0;
/*  56 */     int y1 = (y >= 4) ? 1 : 0;
/*  57 */     int z1 = (z >= 4) ? 1 : 0;
/*  58 */     int index = (x1 * 2 + z1) * 2 + y1;
/*  59 */     this.quads.clear(index);
/*     */   }
/*     */   
/*     */   public boolean isQuadSolid(int x, int y, int z) {
/*  63 */     return !this.quads.get((x * 2 + z) * 2 + y);
/*     */   }
/*     */   
/*     */   public boolean isBlockEmpty() {
/*  67 */     byte[] ba = toByteArray(this.data);
/*  68 */     for (byte b : ba) {
/*  69 */       if (b != -1)
/*  70 */         return false; 
/*     */     } 
/*  72 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145839_a(NBTTagCompound nbttc) {
/*  80 */     super.func_145839_a(nbttc);
/*  81 */     this.metaID = nbttc.func_74771_c("metaID");
/*  82 */     this.typeID = nbttc.func_74765_d("typeID");
/*  83 */     this.data = new BitSet(512);
/*  84 */     this.data.or(fromByteArray(nbttc.func_74770_j("data"), 512));
/*  85 */     this.quads.or(fromByteArray(nbttc.func_74770_j("quads"), 8));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145841_b(NBTTagCompound par1NBTTagCompound) {
/*  93 */     super.func_145841_b(par1NBTTagCompound);
/*  94 */     par1NBTTagCompound.func_74777_a("typeID", this.typeID);
/*  95 */     par1NBTTagCompound.func_74774_a("metaID", this.metaID);
/*  96 */     par1NBTTagCompound.func_74773_a("data", toByteArray(this.data));
/*  97 */     par1NBTTagCompound.func_74773_a("quads", toByteArray(this.quads));
/*     */   }
/*     */ 
/*     */   
/*     */   public void handleInitPacket(NBTTagCompound nbt) {
/* 102 */     this.typeID = nbt.func_74765_d("typeID");
/* 103 */     this.metaID = nbt.func_74771_c("metaID");
/* 104 */     this.data = new BitSet(512);
/* 105 */     this.data.or(fromByteArray(nbt.func_74770_j("data"), 512));
/*     */     
/* 107 */     for (int subX = 0; subX < 8; subX++) {
/* 108 */       for (int subZ = 0; subZ < 8; subZ++) {
/* 109 */         for (int subY = 0; subY < 8; subY++) {
/* 110 */           if (!getBlockExists(subX, subY, subZ)) {
/* 111 */             setQuad(subX, subY, subZ);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 116 */     this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */   }
/*     */ 
/*     */   
/*     */   public void handleDataPacket(NBTTagCompound nbt) {
/* 121 */     this.packetType = nbt.func_74771_c("packetType");
/* 122 */     if (this.packetType == 0) {
/* 123 */       int index = nbt.func_74762_e("index");
/* 124 */       this.data.set(index, false);
/*     */       
/* 126 */       for (int subX = 0; subX < 8; subX++) {
/* 127 */         for (int subZ = 0; subZ < 8; subZ++) {
/* 128 */           for (int subY = 0; subY < 8; subY++) {
/* 129 */             if (!getBlockExists(subX, subY, subZ)) {
/* 130 */               setQuad(subX, subY, subZ);
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/* 135 */       this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/* 136 */     } else if (this.packetType == 1 && !this.field_145850_b.field_72995_K) {
/* 137 */       (PlayerManagerTFC.getInstance().getPlayerInfoFromPlayer(this.entityplayer)).chiselMode = nbt.func_74771_c("chiselMode");
/* 138 */       ((BlockDetailed)TFCBlocks.detailed).xSelected = nbt.func_74771_c("xSelected");
/* 139 */       ((BlockDetailed)TFCBlocks.detailed).ySelected = nbt.func_74771_c("ySelected");
/* 140 */       ((BlockDetailed)TFCBlocks.detailed).zSelected = nbt.func_74771_c("zSelected");
/*     */       
/* 142 */       ((BlockDetailed)TFCBlocks.detailed).onBlockActivatedServer(this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e, this.entityplayer, 0, 0.0F, 0.0F, 0.0F);
/*     */       
/* 144 */       ((BlockDetailed)TFCBlocks.detailed).xSelected = -10;
/* 145 */       ((BlockDetailed)TFCBlocks.detailed).ySelected = -10;
/* 146 */       ((BlockDetailed)TFCBlocks.detailed).zSelected = -10;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void createDataNBT(NBTTagCompound nbt) {
/* 153 */     this.packetType = nbt.func_74771_c("packetType");
/*     */ 
/*     */     
/* 156 */     if (this.packetType == 1)
/*     */     {
/* 158 */       nbt.func_74774_a("chiselMode", (PlayerManagerTFC.getInstance().getClientPlayer()).chiselMode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void createInitNBT(NBTTagCompound nbt) {
/* 166 */     nbt.func_74777_a("typeID", this.typeID);
/* 167 */     nbt.func_74774_a("metaID", this.metaID);
/* 168 */     nbt.func_74773_a("data", toByteArray(this.data));
/*     */   }
/*     */   
/*     */   public static BitSet fromByteArray(byte[] bytes, int size) {
/* 172 */     BitSet bits = new BitSet(size);
/* 173 */     for (int i = 0; i < bytes.length * 8; i++) {
/* 174 */       if ((bytes[bytes.length - i / 8 - 1] & 1 << i % 8) > 0)
/* 175 */         bits.set(i); 
/*     */     } 
/* 177 */     return bits;
/*     */   }
/*     */   
/*     */   public static byte[] toByteArray(BitSet bits) {
/* 181 */     byte[] bytes = new byte[bits.length() / 8 + 1];
/* 182 */     for (int i = 0; i < bits.length(); i++) {
/* 183 */       if (bits.get(i))
/* 184 */         bytes[bytes.length - i / 8 - 1] = (byte)(bytes[bytes.length - i / 8 - 1] | 1 << i % 8); 
/*     */     } 
/* 186 */     return bytes;
/*     */   }
/*     */   
/*     */   public static BitSet turnCube(byte[] bytes, int xAngle, int yAngle, int zAngle) {
/* 190 */     if (xAngle == 0 && yAngle == 0 && zAngle == 0) {
/* 191 */       return fromByteArray(bytes, 512);
/*     */     }
/* 193 */     BitSet data = fromByteArray(bytes, 512);
/* 194 */     BitSet turnedData = new BitSet(512);
/*     */ 
/*     */     
/* 197 */     for (int x = 0; x < 8; x++) {
/* 198 */       for (int z = 0; z < 8; z++) {
/* 199 */         for (int y = 0; y < 8; y++) {
/* 200 */           int xCoord = x, yCoord = y, zCoord = z;
/*     */           
/*     */           int i;
/* 203 */           for (i = 0; i < xAngle; i += 90) {
/*     */             
/* 205 */             int buf = yCoord;
/* 206 */             yCoord = 7 - zCoord;
/* 207 */             zCoord = buf;
/*     */           } 
/*     */           
/* 210 */           for (i = 0; i < zAngle; i += 90) {
/*     */             
/* 212 */             int buf = xCoord;
/* 213 */             xCoord = 7 - yCoord;
/* 214 */             yCoord = buf;
/*     */           } 
/*     */           
/* 217 */           for (i = 0; i < yAngle; i += 90) {
/*     */             
/* 219 */             int buf = zCoord;
/* 220 */             zCoord = 7 - xCoord;
/* 221 */             xCoord = buf;
/*     */           } 
/*     */           
/* 224 */           int srcI = (x * 8 + z) * 8 + y;
/* 225 */           int resI = (xCoord * 8 + zCoord) * 8 + yCoord;
/* 226 */           turnedData.set(resI, data.get(srcI));
/*     */         } 
/*     */       } 
/* 229 */     }  return turnedData;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\TileEntities\TEDetailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */