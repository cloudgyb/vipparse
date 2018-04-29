/*工具类放在这里
 */


export default {
  reloadImg (imgObj, imgSrc, maxErrorNum) {
    if (maxErrorNum > 0) {
      imgObj.onerror = function() {
        reSetImgUrl(imgObj, imgSrc, maxErrorNum - 1);
      };
      setTimeout(function() {
        imgObj.src = imgSrc;
      }, 500);
    } else {
      imgObj.onerror = null;
      imgObj.src = imgSrc;
    }
  }
}
