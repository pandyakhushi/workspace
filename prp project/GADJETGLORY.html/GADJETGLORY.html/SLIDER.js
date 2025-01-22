<div class="dots">
                <span class="dot" data-slide="1"></span>
                <span class="dot" data-slide="2"></span>
                <span class="dot" data-slide="3"></span>
                <span class="dot" data-slide="4"></span>
                <span class="dot" data-slide="5"></span>
                <span class="dot" data-slide="6"></span>
            </div>


const slider = document.querySelector('.slider');
const slides = document.querySelectorAll('.slide');
const dots = document.querySelectorAll('.dot');

let currentSlide = 0;
let interval = setInterval(() => {
    currentSlide++;
    if (currentSlide >= slides.length) currentSlide = 0;
    updateSlide();
}, 2000);

function updateSlide() {
    slides.forEach((slide, index) => {
        slide.style.opacity = index === currentSlide ? 1 : 0;
    });
    dots.forEach((dot, index) => {
        dot.classList.toggle('active', index === currentSlide);
        dot.classList.toggle('dot-active-bar', index === currentSlide);
    });
}

dots.forEach((dot, index) => {
    dot.addEventListener('click', () => {
        currentSlide = index;
        updateSlide();
    });
});