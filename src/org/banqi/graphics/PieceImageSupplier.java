package org.banqi.graphics;

import org.banqi.client.Piece;

import com.google.gwt.resources.client.ImageResource;

/**
 * A mapping from Piece to its ImageResource.
 * The images are all of size 100x100 (width x height).
 */
public class PieceImageSupplier {
  private final PieceImages pieceImages;

  public PieceImageSupplier(PieceImages pieceImages) {
    this.pieceImages = pieceImages;
  }

  public ImageResource getResource(PieceImage pieceImage) {
    switch (pieceImage.kind) {
      case BACK:
        return getBackOfPieceImage();
      case HIGHLIGHT:
        return getHighLightPieceImage(pieceImage.piece);
      case NORMAL:
        return getPieceImage(pieceImage.piece);
      default:
        throw new RuntimeException("Forgot kind=" + pieceImage.kind);
    }
  }

  public ImageResource getBackOfPieceImage() {
    return pieceImages.back();
  }

  public ImageResource getHighLightPieceImage(Piece piece) {
    switch (piece.getColor()) {
      case RED:
        switch (piece.getKind()) {
          case GENERAL: return pieceImages.rgenHighLight();
          case ADVISOR: return pieceImages.radvHighLight();
          case ELEPHANT: return pieceImages.releHighLight();
          case CHARIOT: return pieceImages.rchaHighLight();
          case HORSE: return pieceImages.rhorHighLight();
          case CANNON: return pieceImages.rcanHighLight();
          case SOLDIER: return pieceImages.rsolHighLight();
          default:
            throw new RuntimeException("Forgot kind=" + piece.getKind());
        }
      case BLACK:
        switch (piece.getKind()) {
          case GENERAL: return pieceImages.bgenHighLight();
          case ADVISOR: return pieceImages.badvHighLight();
          case ELEPHANT: return pieceImages.beleHighLight();
          case CHARIOT: return pieceImages.bchaHighLight();
          case HORSE: return pieceImages.bhorHighLight();
          case CANNON: return pieceImages.bcanHighLight();
          case SOLDIER: return pieceImages.bsolHighLight();
          default:
            throw new RuntimeException("Forgot kind=" + piece.getKind());
        }
      default:
        throw new RuntimeException("Forgot color=" + piece.getColor());
    }
  }
  
  public ImageResource getPieceImage(Piece piece) {
    switch (piece.getColor()) {
      case RED:
        switch (piece.getKind()) {
          case GENERAL: return pieceImages.rgen();
          case ADVISOR: return pieceImages.radv();
          case ELEPHANT: return pieceImages.rele();
          case CHARIOT: return pieceImages.rcha();
          case HORSE: return pieceImages.rhor();
          case CANNON: return pieceImages.rcan();
          case SOLDIER: return pieceImages.rsol();
          default:
            throw new RuntimeException("Forgot kind=" + piece.getKind());
        }
      case BLACK:
        switch (piece.getKind()) {
          case GENERAL: return pieceImages.bgen();
          case ADVISOR: return pieceImages.badv();
          case ELEPHANT: return pieceImages.bele();
          case CHARIOT: return pieceImages.bcha();
          case HORSE: return pieceImages.bhor();
          case CANNON: return pieceImages.bcan();
          case SOLDIER: return pieceImages.bsol();
          default:
            throw new RuntimeException("Forgot kind=" + piece.getKind());
        }
      default:
        throw new RuntimeException("Forgot color=" + piece.getColor());
    }
  }
}