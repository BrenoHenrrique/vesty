FROM python:3.11-slim

RUN apt-get update && \
    apt-get install -y tesseract-ocr tesseract-ocr-por && \
    apt-get clean

WORKDIR /app
COPY requirements.txt .
RUN pip install -r requirements.txt

COPY app.py .

CMD ["uvicorn", "app:app", "--host", "0.0.0.0", "--port", "8080"]
